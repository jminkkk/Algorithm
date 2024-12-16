import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);

        int[] dp = new int[n + 2]; // dp[n] -> 돌이 n일 때 갯수

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        if (n < 3) {
            if (dp[n] % 2 == 1) {
                System.out.println("SK");
            } else {
                System.out.println("CY");
            }
            return;
        }

        for (int i = 3; i <= n; i++) {
            int c1 = dp[i - 1] + 1;
            int c2 = dp[i - 3] + 1;
            dp[i] = Math.min(c1, c2);
        }

        if (dp[n] % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
