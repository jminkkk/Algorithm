
import java.util.*;
class Solution {
    
    List<List<Integer>> graph = new ArrayList<>();
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) graph.add(new ArrayList<>());
        
        for (int[] e: edges) {
            int a = e[0];
            int b = e[1];
            List<Integer> aList = graph.get(a);
            aList.add(b);
            List<Integer> bList = graph.get(b);
            bList.add(a);
        }
        
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        dfs(0, 1, 0, info, visited);
        
        return answer;
    }
    
    public void dfs(int now, int sheepCnt, int wolfCnt, int[] info, boolean[] visited) {
        // 방문
        answer = Math.max(answer, sheepCnt);
            
        // 이동
        for (int i = 0; i < info.length; i++) {
            if (!visited[i]) continue;
            
            List<Integer> list = graph.get(i);
            for (int j = 0; j < list.size(); j++) {
                int next = list.get(j);

                // 이미 방문 했다면 안감
                if (visited[next]) continue;

                // 가는 순간 양 죽으면 안감
                if (info[next] == 1 && sheepCnt == wolfCnt + 1) continue;

                visited[next] = true;

                if (info[next] == 0) dfs(next, sheepCnt + 1, wolfCnt, info, visited);
                else dfs(next, sheepCnt, wolfCnt + 1, info, visited);

                visited[next] = false;
            }
        }            
    }
}