import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public static int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]); // 루트찾기
        return parent[i];
    } // 부모찾기

    public static boolean union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA == rootB) return false; // 사이클
        parent[rootA] = rootB; // 부모가 다르면 나에게 합치기
        return true;
    }
    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java//input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] str = br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);

        int[] parent = new int[v];
        for (int i = 0; i < v; i++) parent[i] = i;

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            str = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(str[0]) - 1;
            edges[i][1] = Integer.parseInt(str[1]) - 1;
            edges[i][2] = Integer.parseInt(str[2]);
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        List<int[]> mst = new ArrayList<>();
        int dist = 0;
        for (int[] edge: edges) {
            if (!union(parent, edge[0], edge[1])) continue;

            mst.add(edge);
            dist += edge[2];

            if (mst.size() == v - 1) break;
        }

        System.out.println(dist);


        bw.flush();
        bw.close();
        br.close();
    }
}
