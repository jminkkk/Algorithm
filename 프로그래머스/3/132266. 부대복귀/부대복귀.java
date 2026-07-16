import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] depths = new int[n + 1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] r: roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        int depth = 0;
        boolean[] visited = new boolean[n + 1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        visited[destination] = true;
        depths[destination] = depth++;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // 노드 방문
                int now = q.poll();
                
                // 다음 노드 처리
                List<Integer> close = graph.get(now);
                for (int next: close) {
                    if (visited[next]) continue;
                    q.add(next);
                    visited[next] = true;
                    depths[next] = depth;
                }
            }

            depth++;
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int node = sources[i];
            if (!visited[node]) {
                answer[i] = -1;
                continue;
            }
            
            answer[i] = depths[node];
        }
        
        return answer;
    }
}

