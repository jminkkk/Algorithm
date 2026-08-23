import java.util.*;

class Solution {
    int answer;
    int[] parent;
    
    public int solution(int[] info, int[][] edges) {
        // 그래프 그리기
        int n = info.length;
        parent = new int[n];
        parent[0] = -1;
        
        for (int[] e: edges) {
            int p = e[0];
            int s = e[1];
            parent[s] = p;
        }
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(info, 1, 0, visited); 
        
        return answer;
    }
    
    public void dfs(int[] info, int sheep, int wolf, boolean[] visited) {
        answer = Math.max(answer, sheep);

        // 1. 현재까지 도달한 양의 개수가 앞으로 갈 노드의 늑대 가수 보다 큰지
        // 2. 1번에서 통과면 현재까지 간 경로에 앞으로 갈 노드의 부모 노드가
        for (int i = 0; i < info.length; i++) {
            if (visited[i]) continue;
            if (!visited[parent[i]]) continue;
            
            int ns = sheep + (info[i] == 0 ? 1 : 0);
            int nw = wolf  + (info[i] == 1 ? 1 : 0);

            if (ns <= nw) continue;
            visited[i] = true;
            dfs(info, ns, nw, visited);
            visited[i] = false;
        }
    }
}

// 이진 트리
// 경로 중 양 <= 늑대이면서 양의 갯수를 최대화
// 이미 간 경로를 다시 탐색 가능 | 갯수는 증가 X
// 그냥 갈 수 있을 때까지 계속 왔다갔다

// 1. 각 양들을 얻기위해 거쳐야하는 늑대 개수 저장
// 2. 갈 수 있는 양들 득템
    // 2-1. 현재 가진 양들의 수보다 거쳐야 하는 늑대 개수가 적으면서
    // 2-2. 경로상 도달할 수 있는지

// 자식 노드 확인
    // 갈 수 있다면 이동
// 못간다면 