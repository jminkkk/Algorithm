
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_16930/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        int[][] distance = new int[n + 1][m + 1];
        boolean[][] map = new boolean[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            s =  br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = s[j].equals(".");
            }
        }

        s =  br.readLine().split(" ");
        int x1 = Integer.parseInt(s[0]);
        int y1 = Integer.parseInt(s[1]);
        int x2 = Integer.parseInt(s[2]);
        int y2 = Integer.parseInt(s[3]);

        Queue<Point> q = new LinkedList<>();
        distance[x1][y1] = 0;
        visited[x1][y1] = true;
        q.add(new Point(x1, y1));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == x2 && p.y == y2) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= k; j++) {
                    int nx = p.x + dx[i] * j;
                    int ny = p.y + dy[i] * j;

                    if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
                    if (visited[nx][ny]) {
                        if (distance[nx][ny] < distance[p.x][p.y] + 1) break;
                        else continue;
                    }
                    if (!map[nx][ny]) break; // i 방향으로는 못감

                    distance[nx][ny] = distance[p.x][p.y] + 1;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }

        if (!visited[x2][y2]) System.out.println(-1);
        else System.out.println(distance[x2][y2]);

        bw.flush();
        bw.close();
        br.close();
    }
}
