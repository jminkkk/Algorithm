
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public static int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    public static boolean union(int a, int b, int[] parent) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) return false;
        parent[rootA] = rootB;
        return true;
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java//input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 크루스칼

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);

//        List<int[]>[] graph = new ArrayList[n + 1];
        List<int[]> kruskalGraph = new ArrayList<>();
//        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            kruskalGraph.add(new int[]{a, b, c});
//            graph[a].add(new int[]{b, c});
//            graph[b].add(new int[]{a, c});
        }

        kruskalGraph.sort((a, b) -> a[2] - b[2]);
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) parents[i] = i;
        int sum = 0;

        List<int[]> mst = new ArrayList<>();
        for (int[] edge: kruskalGraph) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (!union(a, b, parents)) continue;

            mst.add(new int[]{a, b, cost});
            sum += cost;
            if (mst.size() == n - 1) break;
        }

        System.out.println(sum);

        bw.flush();
        bw.close();
        br.close();
    }
}
