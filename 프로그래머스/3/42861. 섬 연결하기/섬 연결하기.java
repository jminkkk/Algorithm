import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] c: costs) {
            int from = c[0];
            int to = c[1];
            int cost = c[2];
            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0, 0});
            
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            if (visited[node]) continue;
            visited[node] = true;
            answer += cost;
            
            List<int[]> nexts = graph[node];
            for (int[] nx: nexts) {
                if (!visited[nx[0]]) pq.add(nx);
            }
        }
        
        return answer;
    }
}

// MST
// 크루스칼
// 프림