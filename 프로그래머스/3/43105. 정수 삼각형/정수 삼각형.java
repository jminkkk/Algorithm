class Solution {
    
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[n - 1].length;
        int[][] dp = new int[n][m];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1;  i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                else if (j == 0) dp[i][j] = triangle[i][j] + dp[i - 1][j];
                else dp[i][j] = Math.max(triangle[i][j] + dp[i - 1][j - 1], triangle[i][j] + dp[i - 1][j]);
                
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) answer = Math.max(answer, dp[n - 1][i]);
        
        return answer;
    }
}

// 7
// 3 8
// 8 1 0
// 2 7 4 4
// 4 5 2 6 5