class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n == 1) {
            return 1;
        }
        
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] = dp[i] % 1000000007;
        }
        
        int answer = dp[n] % 1000000007;
        return answer;
    }
}