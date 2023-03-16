class Solution {
    //n은 노트북의 개수
    //computers는 연결에 대한 정보
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] computers, boolean[] visited, int n){
        visited[n] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(computers[n][i] == 1 && !visited[i]){
                dfs(computers, visited, i);
            }
        }
    }
}