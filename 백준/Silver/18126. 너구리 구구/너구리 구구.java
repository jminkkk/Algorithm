import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        long[][] values = new long[n][n];
        Map<Integer, List<Integer>> fromTo = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String[] str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]) - 1;
            int to = Integer.parseInt(str[1]) - 1;
            long value = Long.parseLong(str[2]);

            values[from][to] = value;
            values[to][from] = value;

            List<Integer> close = fromTo.getOrDefault(from, new ArrayList<>());
            close.add(to);
            fromTo.put(from, close);
            close = fromTo.getOrDefault(to, new ArrayList<>());
            close.add(from);
            fromTo.put(to, close);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        boolean[] visited = new boolean[n];

        long max = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            max = Math.max(max, node.value);

            List<Integer> ones = fromTo.get(node.to);
            visited[node.from] = true;
            for (int i = 0; i < ones.size(); i++) {
                int next = ones.get(i);
                if (!visited[next]) {
                    queue.add(new Node(node.to, next, node.value + values[node.to][next]));
                    visited[node.to] = true;
                }
            }
        }
        System.out.println(max);
    }
}

class Node {
    int from;
    int to;
    long value;

    public Node(int from, int to, long value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}
//5
//1 3 100
//3 5 100
//1 2 100000
//4 5 10000000
