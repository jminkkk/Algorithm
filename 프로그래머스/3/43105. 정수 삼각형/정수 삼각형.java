class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i - 1][j - 1], 
                                    dp[i - 1][j] + triangle[i - 1][j - 1]);
                
                // System.out.println(i + " " + j + " " + dp[i][j]);
            }
        }
        
        for (int i = 1; i <= len; i++) answer = Math.max(answer, dp[len][i]);
        return answer;
    }
}