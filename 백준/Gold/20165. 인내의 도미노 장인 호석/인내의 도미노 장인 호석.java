import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int n, m, r;
    static int[][] arr, copy;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]); // 행
        m = Integer.parseInt(str[1]); // 열
        r = Integer.parseInt(str[2]); // 라운드 횟수

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(copy[i], 0);
        }

        int score = 0;
        for (int i = 0; i < r; i++) {
            str = br.readLine().split(" "); // 공격
            int x = Integer.parseInt(str[0]) - 1;
            int y = Integer.parseInt(str[1]) - 1;
            char dir = str[2].charAt(0);
            score += attack(x, y, dir);

            str = br.readLine().split(" "); // 수비
            int reX = Integer.parseInt(str[0]) - 1;
            int reY = Integer.parseInt(str[1]) - 1;
            copy[reX][reY] = 0;
        }

        System.out.println(score);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == -1) System.out.print("F ");
                else System.out.print("S ");
            }
            System.out.println();
        }
    }

    private static int attack(int x, int y, char dir) {
        if (copy[x][y] == -1) {
            return 0;
        }

        int direction = 0;
        if (dir == 'E') direction = 0;
        else if (dir == 'W') direction = 1;
        else if (dir == 'S') direction = 2;
        else if (dir == 'N') direction = 3;

        int fallen = 0;
        int height = arr[x][y];
        while (height > 0) {
            if (x < 0 || x >= n || y < 0 || y >= m || copy[x][y] == -1) {
                break;
            }
            if (copy[x][y] == 0) {
                copy[x][y] = -1;
                fallen++;
            }
            height--;
            x += dx[direction];
            y += dy[direction];
        }
        return fallen;
    }
}