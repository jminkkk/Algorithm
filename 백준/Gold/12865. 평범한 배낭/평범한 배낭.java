import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max = 0;
    static int n, m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        dp = new int[n + 1][m + 1];
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.fill(arr[0], 0);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                // dp[i][w] 최대 무게가 w일 때, i번째 가방까지 포함한 최대 가치
                int w = arr[i][0];
                if (w > j) dp[i][j] = dp[i - 1][j]; // 지금꺼는 못 넣어
                else {
                    int v = arr[i][1];
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
