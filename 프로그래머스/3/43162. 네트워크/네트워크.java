import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            answer++;
            visited[i] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int j = i + 1; j < n; j++) {
                    // if (j == i) continue;
                    if (visited[j]) continue;
                    
                    if (computers[now][j] == 1) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}