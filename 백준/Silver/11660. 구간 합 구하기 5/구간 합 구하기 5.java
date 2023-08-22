import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        // N N
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][0] + arr[0][1];
        dp[1][0] = arr[0][0] + arr[1][0];

        for (int i = 2; i < N; i++) {
            dp[0][i] = dp[0][i -  1] + arr[0][i];
            dp[i][0] = dp[i -  1][0] + arr[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] +  arr[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]) - 1;
            int y1 = Integer.parseInt(str[1]) - 1;
            int x2 = Integer.parseInt(str[2]) - 1;
            int y2 = Integer.parseInt(str[3]) - 1;

            if (x1 == 0 && y1 == 0) System.out.println(dp[x2][y2]);
            else if (x1 == 0) System.out.println(dp[x2][y2] - dp[x2][y1 - 1]);
            else if (y1 == 0) System.out.println(dp[x2][y2] - dp[x1 - 1][y2]);
            else System.out.println(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]);
        }
    }
}
