
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1005/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int t = Integer.parseInt(str[0]);

        while (t-- > 0) {
            str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            str = br.readLine().split(" ");
            int[] cost = new int[n + 1];
            for (int i = 0; i < n; i++) {
                cost[i + 1] = Integer.parseInt(str[i]);
            }

            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            int[] degree = new int[n + 1];
            for (int i = 0; i < m; i++) {
                str = br.readLine().split(" ");
                int fromNd = Integer.parseInt(str[0]);
                int toNd = Integer.parseInt(str[1]);
                if (fromNd == toNd) continue;
                graph[fromNd].add(toNd);
                degree[toNd]++;
            }

            str = br.readLine().split(" ");
            int w =  Integer.parseInt(str[0]);
            System.out.println(topologicalSort(n, cost, degree, graph, w));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int topologicalSort(int n, int[] cost, int[] degree, List<Integer>[] graph, int w) {
        int[] dist = new int[n + 1];

        List<Integer> topology = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] != 0) continue;

            q.add(i);
            dist[i] = cost[i];
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            if (!topology.contains(now)) topology.add(now);

            for (int next: graph[now]) {
                degree[next]--;
                dist[next] = Math.max(dist[next], cost[next] + dist[now]);

                if (degree[next] == 0 && !topology.contains(next)) {
                    q.add(next);
                }
            }
        }

        return dist[w];
    }
}
