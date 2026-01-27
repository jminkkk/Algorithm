import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] answer = new int[n + 1]; // 1부터 거리가 i인 노드 개수 
        
        Map<Integer, List<Integer>> connected = new HashMap<>();
        
        for (int[] arr: edge) { // 노드들 연결 세팅
            int a = arr[0] - 1;
            int b = arr[1] - 1;
            List aList = connected.getOrDefault(a, new ArrayList<>());
            aList.add(b);
            connected.put(a, aList);
            
            List bList = connected.getOrDefault(b, new ArrayList<>());
            bList.add(a);
            connected.put(b, bList);
        }
        
        boolean[] visited = new boolean[n];
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 1));
        visited[0] = true;
        answer[0]++;
        
        while (!q.isEmpty()) {
            Node nd = q.poll();
            answer[nd.depth]++;
            
            List<Integer> list = connected.getOrDefault(nd.num, new ArrayList<>());
            
            for (int next: list) {
                if (visited[next]) continue;
                
                q.add(new Node(next, nd.depth + 1));
                visited[next] = true;
            }
        }
        
        for (int i = n; i  >= 0; i--) {
            if (answer[i] != 0) return answer[i];
        }
        
        return 0;
    }
}

class Node {
    int num;
    int depth;
    
    Node(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}