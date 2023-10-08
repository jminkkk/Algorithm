
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // X가 3으로 나누어 떨어지면, 3으로 나눈다.
        // X가 2로 나누어 떨어지면, 2로 나눈다.
        // 1을 뺀다.
        // 연산을 통해 1을 만들 때, 연산을 사용하는 횟수의 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            // 수만큼의 조합 생성
            // 모든 경우에서 N이 안나오면 ++하기
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
