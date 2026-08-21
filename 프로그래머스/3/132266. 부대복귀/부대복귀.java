import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // destination 에서 다른 지역까지의 최단 거리 구한 후 sources에 대한 거리만 반환
        // 다익스트라 -> O(V log E) -> O(100_000 * log 500_000) -> O(50_000_000 쫌 넘음)
        List<Integer>[] list = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            
            if (i == destination) dist[i] = 0;
            else dist[i] = 500_000; // 500_000이 적절한지 확신 X
        }
        
        for (int[] r: roads) {
            int n1 = r[0];
            int n2 = r[1];
            list[n1].add(n2);
            list[n2].add(n1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.add(new Node(destination, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.n] = true;
            dist[now.n] = Math.min(dist[now.n], now.v);
                
            List<Integer> nexts = list[now.n];
            for (int next: nexts) {
                if (visited[next]) continue; // 가중치 1 아니라면, 확신 X
                pq.add(new Node(next, now.v + 1));
            }
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int nd = sources[i];
            if (visited[nd]) answer[i] = dist[nd];
            else answer[i] = -1;
        }
        
        return answer;
    }
}

class Node implements Comparable<Node> {
    int n;
    int v;
    
    Node(int n, int v) {
        this.n = n;
        this.v = v;
    }
    
    public int compareTo(Node o) {
        return Integer.compare(this.v, o.v);
    }
}