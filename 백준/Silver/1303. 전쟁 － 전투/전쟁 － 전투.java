

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static boolean[][] visited;
    static char[][] arr;
    static int sum;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        visited =  new boolean[m][n];
        arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int bSum = 0;
        int wSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                int sum = dfs(i, j);

                if (arr[i][j] == 'B') bSum += sum * sum;
                else  if (arr[i][j] == 'W') wSum += sum * sum;
            }
        }

        System.out.println(wSum + " " + bSum);

        bw.flush();
        bw.close();
        br.close();
    }

    public int dfs(int x, int y) {
        sum = 0;
        recursion(x, y);
        return sum;
    }

    public void recursion(int x, int y) {
        visited[x][y] = true;
        sum++;

        for (int d = 0; d < 4; d++) {
            int nx =  x + dx[d];
            int ny = y + dy[d];
            if (canGo(nx, ny, arr[x][y]))  recursion(nx, ny);
        }
    }

    public boolean canGo(int x, int y, char ch) {
        return x >= 0 && y >= 0 && x < arr.length && y < arr[0].length
                && arr[x][y] == ch && !visited[x][y];
    }
}
//
//int wSum = 0;
//int bSum = 0;
//
//for (int i = 0; i < n; i++) {
//	for (int j = 0; j < m; j++) {
//		if (visited[i][j]) continue;
//
//		int count = dfs(i, j, visited);
//
//		if (arr[i][j] == 'W') wSum += count;
//		else bSum += count;
//	}
//}
//
//
//dfs(int x, int y, boolean[][] visited)
//	int cnt = 0;
//	return recursive(x, y, 1, visited);
//
//recursive(int x, int y, int cnt, boolean[][] visited) {
//	visited[x][y] = true;
//
//	for (int i = 0; i < 4; i++) {
//		int nx = x + dx[i];
//		int ny = y + dy[i];
//
//		if (!canGo(nx, ny, visited, arr[x][y])) continue;
//		recursive(nx, ny, cnt + 1, visited);
//	}
//
//	return cnt;
//}
//
//canGo(int x, int y, boolean[][] visited, char c)
//	return x >= 0 && x < m && y >= 0 && y < n
//		&& !visited[x][y] && arr[x][y] == c
