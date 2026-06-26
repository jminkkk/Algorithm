import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            bfs(i, visited, computers);
            answer++;
        }
        return answer;
    }
    
    public void bfs(int cur, boolean[] visited, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        visited[cur] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] || i == now) continue;
                if (computers[now][i] == 0) continue;
                
                visited[i] = true;
                q.add(i);
            }
        }
    }
}