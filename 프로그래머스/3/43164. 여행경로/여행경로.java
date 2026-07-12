import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>(); // 출발 여행지, tickets 인덱스
    List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            List<Integer> list = map.getOrDefault(start, new ArrayList<>());
            list.add(i);
            map.put(start, list);
        }

        for (List<Integer> list : map.values()) {
            list.sort((a, b) -> tickets[a][1].compareTo(tickets[b][1]));
        }
        
        dfs(tickets, "ICN", "ICN", 0, new boolean[tickets.length]);
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
    
    private void dfs(String[][] tickets, String routes, String from, int depth, boolean[] visited) {
        if (depth == tickets.length) {
            answer.add(routes);
            return;
        }

        List<Integer> nexts = map.get(from);
        if (nexts == null) return;

        for (int next: nexts) {
            if (visited[next]) continue;
            String to = tickets[next][1];
            visited[next] = true;
            dfs(tickets, routes + " " + to, to, depth + 1, visited);
            visited[next] = false;
        }
    }
}
