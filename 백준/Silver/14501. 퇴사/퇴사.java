
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    // N + 1일 후에 퇴사 남은 N일 동안, 최대한 많은 상담
    // 하루에 하나씩 서로 다른 사람의 상담
    // 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi
    // 최대 이익이 되도록
    static int N; // 상담 가능한 총 날짜 - N일
    static int[] t;
    static int[] p;  // 각 날짜별 상담 기간, 금액


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        t = new int[N];
        p = new int[N];

        for (int i = 0; i < N; i++) { // 날짜당 상담 기간, 금액 입력 받기
            String[] str = br.readLine().split(" ");
            t[i] = Integer.parseInt(str[0]);
            p[i] = Integer.parseInt(str[1]);
        }

        int[] dp = new int[N + 1]; // 인덱스까지의 받을 수 있는 최대 수익

        // 점화식
        // dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);

        for (int i = 0; i < N; i++) {
            if (i + t[i] <= N) { // 상담이 가능할 경우
                dp[i +t[i]] = Math.max(dp[i + t[i]], dp[i] +p[i]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }

}

