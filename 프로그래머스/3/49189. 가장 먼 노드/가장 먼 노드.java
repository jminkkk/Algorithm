import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int cnt = 0;
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e: edge) {
            int from = e[0];
            int to = e[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                for (int next: graph[now]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
            
            cnt = size;
        }
        
        return cnt;
    }
}