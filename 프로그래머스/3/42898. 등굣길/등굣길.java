class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n][m];
        boolean[][] isPuddle = new boolean[n][m];
        for (int[] p: puddles) {
            isPuddle[p[1] - 1][p[0] - 1] = true;
        }        
        
        dp[0][0] = 0;
        if (n > 0 && !isPuddle[1][0]) dp[1][0] = 1;
        if (m > 0 && !isPuddle[0][1]) dp[0][1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // 위에서 아래로
                if (i != 0) dp[i][j] = (dp[i - 1][j] + dp[i][j]) % 1_000_000_007;
                
                // ->
                if (j != 0) dp[i][j] = (dp[i][j - 1] + dp[i][j]) % 1_000_000_007;
            }
        }
        
        return dp[n - 1][m - 1];
    }
}