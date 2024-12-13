import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        dp = new int[n][3];

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
                dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
            }
        }

        int ans = (dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % 9901;
        System.out.println(ans);
    }
}
