class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            answer++;
            dfs(computers, i, visited);
            visited[i] = true;
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, int idx, boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] || i == idx) continue;
            if (computers[idx][i] == 0) continue;
            
            visited[i] = true;
            dfs(computers, i, visited);
        }
    }
}