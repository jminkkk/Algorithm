class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        // 거리 = 최단(s -> 중간경유지) + 최단(중간경유지 -> a) + 최단(중간경유지 -> b)
        // 1. 중간경유지 잡고 다익스트라 -> O(V * E log V) -> O(V * V^2 * log V)
        // 2. 플로이드워셜 -> O(V^3)
        
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = 100_00 * 200;
            }
        }
        
        for (int[] f: fares) {
            int n1 = f[0];
            int n2 = f[1];
            int v = f[2];
            dist[n1][n2] = v;
            dist[n2][n1] = v;
        }
        
        for (int k = 1; k <=n; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int answer = dist[s][a] + dist[s][b]; // 초기값: 중간경유 없는 경우
        for (int i = 1; i <= n; i++) {
            int cost =
                    dist[s][i]
                    + dist[i][a]
                    + dist[i][b];
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
}