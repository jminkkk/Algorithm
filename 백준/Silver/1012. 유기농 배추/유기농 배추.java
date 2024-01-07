
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static boolean[][] visited;
    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;
            String[] str = br.readLine().split(" ");
            int M = Integer.parseInt(str[0]), N = Integer.parseInt(str[1]), K = Integer.parseInt(str[2]);
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                String[] str2 = br.readLine().split(" ");
                int x = Integer.parseInt(str2[0]), y = Integer.parseInt(str2[1]);
                map[y][x] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        count++;
                        dfs(j, k);
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}
