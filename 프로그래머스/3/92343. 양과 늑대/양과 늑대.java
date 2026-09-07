class Solution {
    int max = 0;
    int[] parents;
    
    public int solution(int[] info, int[][] edges) {
        parents = new int[info.length];
        parents[0] = -1;
        for (int[] e: edges) {
            int p = e[0];
            int s = e[1];
            parents[s] = p;
        }
        
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        dfs(1, 0, info, visited);
        
        return max;
    }
    
    public void dfs(int sheep, int wolf, int[] info, boolean[] visited) {
        max = Math.max(max, sheep);

        for (int i = 0; i < info.length; i++) {
            if (visited[i]) continue;
            
            // 부모가 이미 방문했어야 함
            if (!visited[parents[i]]) continue;
            
            // 양 늑대 조건 만족
            if (info[i] == 0) {
                visited[i] = true;
                dfs(sheep + 1, wolf, info, visited);
                visited[i] = false;
            } else {
                if (sheep <= wolf + 1) continue;
                
                visited[i] = true;
                dfs(sheep, wolf + 1, info, visited);
                visited[i] = false;
            }
        }
    }
}