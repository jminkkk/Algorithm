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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_11724/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        boolean[][] arr = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            arr[a][b] = true;
            arr[b][a] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            cnt++;
            dfs(i, visited, arr);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public void dfs(int i, boolean[] visited, boolean[][] arr) {
        visited[i] = true;

        for (int j = 0; j < arr[i].length; j++) {
            if (i == j || !arr[i][j] || visited[j]) continue;

            dfs(j, visited, arr);
        }
    }
}


//main
//	for 1...m
//		arr[a][b] = true;
//		arr[b][a] = true;
//
//	for 1...n
//		if (visited[i]) continue;
//
//		cnt++;
//		dfs(i, visited, arr);
//
//dfs
//	for 1...n
//		if (i == cur || arr[i][cur] || visited[i]) continue;
//
//		dfs(i, visited, arr);
