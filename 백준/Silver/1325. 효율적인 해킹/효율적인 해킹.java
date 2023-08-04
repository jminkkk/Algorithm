import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, num;
    static List<List<Integer>> node;
    static int[] ans;
    static boolean[] visited;
    static int max = 0;
    static List<Integer> ansNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        node = new ArrayList<>();
        ans = new int[N];
        ansNums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            node.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]) - 1;
            int b = Integer.parseInt(str[1]) - 1;
            node.get(a).add(b);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            BFS(i);
        }

        for(int i = 0; i< N; i++) {
            max = Math.max(max, ans[i]);
        }

        for (int i = 0; i < N; i++) {
            if (ans[i] == max) ansNums.add(i);
        }

        Collections.sort(ansNums);
        ansNums.forEach(i -> System.out.print(i + 1 + " "));
    }


    public static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();

            for (int i : node.get(a)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    ans[i]++;
                }
            }
        }
    }
}
