
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, min = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int depth, int sum) {
        if (depth == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && notAllVisited(i, j)) {
                    int hap = map[i][j];

                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        visited[nx][ny] = true;
                        hap += map[nx][ny];
                    }

                    visited[i][j] = true;
                    dfs(depth + 1, sum + hap); 

                    visited[i][j] = false;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    static boolean notAllVisited(int x, int y) {
        if (visited[x][y] == true) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= N || ny >= N || nx < 0 || ny < 0) {
                return false;
            }

            if (visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }
}
