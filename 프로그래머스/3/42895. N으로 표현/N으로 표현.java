import java.util.*;

class Solution {

    Set<Integer>[] dp = new HashSet[9];

    public int solution(int N, int number) {

        for (int i = 0; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }

        dp[1].add(N);

        if (N == number) {
            return 1;
        }

        for (int i = 2; i <= 8; i++) {

            findValue(i, N);

            if (dp[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }

    private void findValue(int now, int N) {
        // 1. N을 이어 붙인 숫자 추가
        int repeated = 0;

        for (int i = 0; i < now; i++) {
            repeated = repeated * 10 + N;
        }

        dp[now].add(repeated);

        // 2. N을 사용하는 횟수를 두 그룹으로 나누기
        for (int left = 1; left < now; left++) {

            int right = now - left;

            // 3. 각 그룹에서 만들 수 있는 숫자들을 결합
            for (int a : dp[left]) {
                for (int b : dp[right]) {

                    dp[now].add(a + b);
                    dp[now].add(a - b);
                    dp[now].add(a * b);

                    if (b != 0) {
                        dp[now].add(a / b);
                    }
                }
            }
        }
    }
}