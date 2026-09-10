import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {        
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 100_001;
            }
        }
        
        for (int[] c: costs) {
            int a = c[0];
            int b = c[1];
            int cost = c[2];
            arr[a][b] = cost;
            arr[b][a] = cost;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        // 각 구간 간의 최단 거리
        for (int ctr = 0; ctr < n; ctr++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][ctr] + arr[ctr][j]);
                }
            }
        }
        
        for (int i = 0; i <n; i++) pq.add(new int[]{0, i, arr[0][i]});
        
        int answer = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            
            int from = now[0];
            int to = now[1];
            int cost = now[2];
            
            if (visited[to]) continue;
            
            // System.out.println(from + " " + to + " " + cost + " " + answer);
            visited[to] = true;
            answer += cost;
            
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                pq.add(new int[]{to, i, arr[to][i]});
            }
        }
        
        return answer;
    }
}