import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        int nd = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> con = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] arr = br.readLine().split(" ");
            int e = Integer.parseInt(arr[0]) - 1;
            int s = Integer.parseInt(arr[1]) - 1;

            List<Integer> list = con.getOrDefault(e, new ArrayList<>());
            list.add(s);
            con.put(e, list);

            list = con.getOrDefault(s, new ArrayList<>());
            list.add(e);
            con.put(s, list);
        }

        boolean[] visited = new boolean[nd];

        dfs(0, visited, con);

        int cnt = 0;
        for (boolean b: visited) {
            if (b) cnt++;
        }

        System.out.println(cnt - 1);

        bw.flush();
        bw.close();
        br.close();
    }

    public void dfs(int now, boolean[] visited, Map<Integer, List<Integer>> con) {
        visited[now] = true;
        List<Integer> list = con.getOrDefault(now, new ArrayList<>());

        for (int num: list) {
            if (visited[num]) continue;
            dfs(num, visited, con);
        }
    }
}
//
//boolean[] visited = new boolean[];
//Map<Integer, List<Integer>> con = new HashMap<>();
//
//for (int i: con.get(0)) {
//		if (visited[0][i]) continue;
//		if (!arr[0][i]) continue;
//
//		dfs(i, visited);
//	}
//}
//
//dfs(int now, boolean[] visited) {
//	visited[now] = true;
//	List<Integer> list = con.get(now);
//
//	for (int num: list) {
//		if (visited[num]) continue;
//		dfs(num, visited);
//	}
//}
