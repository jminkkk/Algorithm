
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] pay = new int[N + 2];
        int[] time = new int[N + 2];
        int[] dp = new int[N + 2]; // N일차에 얻을 수 있는 최대 수익

        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");
            time[i] = Integer.parseInt(str[0]);
            pay[i] = Integer.parseInt(str[1]);
        }

        int max = 0;

        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(dp[i], max);

            // 하고 나서
            int future = i + time[i];
            if (future <= N + 1) {
                dp[future] = Math.max(max + pay[i], dp[future]);
            }
        }

        System.out.println(max);
    }
}
