import java.awt.Point;
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_17086/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        boolean[][] visited = new boolean[n][m];
        int[][] arr = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] != 1) continue;

                q.add(new Point(i, j));
                visited[i][j] = true;
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[p.x][p.y] + 1;
                q.add(new Point(nx, ny));
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) continue;
                answer = Math.max(answer, dist[i][j]);
            }
        }

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}
