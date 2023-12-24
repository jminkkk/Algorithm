
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int count;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxNum = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                maxNum = Math.max(maxNum, map[i][j]);
            }
        }


        for (int i = 0; i < maxNum; i++) {
            count = 0;
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && map[j][k] > i) {
                        count++;
                        bfs(i, j, k);
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    private static void bfs(int height, int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length) {
                if (!visited[nx][ny] && map[nx][ny] > height) {
                    visited[nx][ny] = true;
                    bfs(height, nx, ny);
                }
            }
        }
    }
}
