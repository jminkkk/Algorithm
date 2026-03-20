
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
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

//        int[][] map = new int[n + 1][n + 1];

        int max = 0;
        for (int i = 0 ; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
            max = Math.max(max, c);
        }

        str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        int lo = 1;
        int hi = max + 1; // yyyn

        while (lo + 1 < hi) { // O(logC) * N * N
            int mid = (lo + hi) / 2;

            if (canMove(mid, graph, a, b, n)) lo = mid;
            else hi = mid;
        }

        System.out.println(lo);

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean canMove(int mid, List<int[]>[] graph, int a, int b, int n ) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(a);
        visited[a] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            List<int[]> con = graph[now];

            if (now == b) return true;

            for (int[] next: con) {
                int nextNd = next[0];
                int weight = next[1];
                if (visited[nextNd]) continue;
                if (weight < mid) continue;

                visited[nextNd] = true;
                q.add(nextNd);
            }
        }

        return visited[b];
    }
}
