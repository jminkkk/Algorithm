
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1766/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] degree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            graph[from].add(to);
            if (from != to) degree[to]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) pq.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int now = pq.poll();

            if (!ans.contains(now)) ans.add(now);

            for (int next: graph[now]) {
                degree[next]--;
                if (degree[next] == 0 && !ans.contains(next)) pq.add(next);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
