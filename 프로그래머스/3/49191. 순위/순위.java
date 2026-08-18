class Solution {
    public int solution(int n, int[][] results) {
        int answer = n;

        int[][] map = new int[n + 1][n + 1];
        for (int[] r: results) {
            int winner = r[0] - 1;
            int loser = r[1] - 1;
            map[winner][loser] = 1;
            map[loser][winner] = -1;
        }
        
        for (int mid = 0; mid < n; mid++) {
            for (int str = 0; str < n; str++) {
                for (int end = 0; end < n; end++) {
                    if (str == end) continue;
                    
                    if (map[str][mid] == 1 && map[mid][end] == 1) {
                        map[str][end] = 1;
                        map[end][str] = -1;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                if (map[i][j] == 0) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
}