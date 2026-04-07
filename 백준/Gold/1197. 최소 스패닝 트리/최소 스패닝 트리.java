import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1197/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);

        List<Node>[] graph = new List[v + 1];
        for (int i = 0; i <= v; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < e; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];

        Set<Integer> mst = new HashSet<>();
        pq.add(new Node(1, 0));

        int sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.num]) continue;
            
            visited[node.num] = true;
            sum += node.cost;
            mst.add(node.num);

            if (mst.size() == v) break;

            for (Node next: graph[node.num]) {
                if (visited[next.num]) continue;
                pq.add(next);
            }
        }

        System.out.println(sum);


        bw.flush();
        bw.close();
        br.close();
    }
}

class Node implements Comparable<Node> {
    int num;
    int cost;

    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
