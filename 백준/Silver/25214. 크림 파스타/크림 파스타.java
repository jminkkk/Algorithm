
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N];

        String[] AStr = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(AStr[i]);
        }

        if (N == 1) {
            System.out.println("0");
            return;
        }

        int min = Math.min(A[1], A[0]);
        int max = Math.max(A[1], A[0]);

        dp[0] = 0;
        dp[1] = Math.max(0, A[1] - A[0]);
        System.out.print(dp[0] + " " + dp[1] + " ");

        for (int i = 2; i < N; i++) {
            int now = A[i];
            dp[i] = Math.max(dp[i - 1], now - min);

            if (min > now) {
                min = now;
            }
            if (max < now) {
                max = now;
            }

            System.out.print(dp[i] + " ");
        }
    }
}
