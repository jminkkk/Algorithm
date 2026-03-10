import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX + 1];
        int[] dist = new int[MAX + 1];
        int[] parent = new int[MAX + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) break;

            int[] nexts = {now - 1, now + 1, now * 2};

            for (int next : nexts) {

                if (next < 0 || next > MAX) continue;

                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    parent[next] = now;

                    q.add(next);
                }
            }
        }

        System.out.println(dist[k]);

        List<Integer> path = new ArrayList<>();
        int cur = k;

        while (cur != n) {
            path.add(cur);
            cur = parent[cur];
        }
        path.add(n);

        Collections.reverse(path);

        for (int x : path) {
            System.out.print(x + " ");
        }
    }
}