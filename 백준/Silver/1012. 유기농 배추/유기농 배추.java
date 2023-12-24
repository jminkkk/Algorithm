
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] arr = br.readLine().split(" ");
            int M = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            int K = Integer.parseInt(arr[2]);

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                String[] temp = br.readLine().split(" ");
                int x = Integer.parseInt(temp[0]);
                int y = Integer.parseInt(temp[1]);
                map[y][x] = 1;
            }

            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!visited[j][k] && map[j][k] == 1) {
                        dfs(map, visited, j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length) {
                if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    dfs(map, visited, nextX, nextY);
                }
            }
        }
    }
}
