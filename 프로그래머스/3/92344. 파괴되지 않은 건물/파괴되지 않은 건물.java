class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] mark = new int[n + 1][m + 1];
        for (int[] s: skill) { // O(S)
            int t = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = t == 1 ? (s[5] * -1) : s[5];
            
            mark[r1][c1] += degree;
            mark[r1][c2 + 1] -= degree;
            mark[r2 + 1][c1] -= degree;
            mark[r2 + 1][c2 + 1] += degree;
        }
        
        int answer = 0;
        int[][] sum = new int[n][m];
        sum[0][0] = mark[0][0];
        
        for (int i = 0; i < n; i++) { // O(N*M)
            for (int j = 0; j < m; j++) {
                sum[i][j] = mark[i][j];

                if (i > 0) sum[i][j] += sum[i - 1][j];
                if (j > 0) sum[i][j] += sum[i][j - 1];
                if (i > 0 && j > 0) sum[i][j] -= sum[i - 1][j - 1];
                
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}

// 적 -> 내구도 감소 -> 0 이하면 파괴
// 아군 -> 내구도 향상
// 파괴된 건물 복구되고 감소된 내구도만큼 향상시켜야 가능
