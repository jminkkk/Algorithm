
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java//input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);

        ArrayList<Integer>[] graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            str = br.readLine().split(" ");
            int fromNd = Integer.parseInt(str[0]);
            int toNd = Integer.parseInt(str[1]);
            if (fromNd != toNd) graph[fromNd].add(toNd);
//            graph[].add(fromNd);
        }

        // 1. 진입차수
        int[] depth = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            for (int toNd : graph[i]) {
                depth[toNd]++;
            }
        }

        // 2. 최초 진입차수 0인 노드들 큐에 삽입
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= v; i++) {
            if (depth[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int nd = q.poll();
            list.add(nd);

            for (int next : graph[nd]) {
                depth[next]--;
                if (depth[next] == 0 && !list.contains(next)) {
                    q.add(next);
                }
            }
        }

        for (int num : list) {
            System.out.print(num + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
