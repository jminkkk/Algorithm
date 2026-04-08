
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

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
        str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);

        boolean[] visited = new boolean[n + 1];
        List<int[]>[] edges = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        Set<Integer> mst = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});

        int cost = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if (visited[now[0]]) continue;
            cost += now[1];
            mst.add(now[0]);
            visited[now[0]] = true;
            
            if (mst.size() == n) break;

            for (int[] next: edges[now[0]]) {
                if (visited[next[0]]) continue;
                pq.add(next);
            }
        }

        System.out.println(cost);

        bw.flush();
        bw.close();
        br.close();
    }
}
