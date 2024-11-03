import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < costs.length; i++) {
            list.get(costs[i][0]).add(new Node(costs[i][1], costs[i][2]));
            list.get(costs[i][1]).add(new Node(costs[i][0], costs[i][2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.start]) continue;
            
            visited[node.start] = true;
            answer += node.weight;
            
            for (int i = 0; i < list.get(node.start).size(); i++) {
                int next = list.get(node.start).get(i).start;
                int cost = list.get(node.start).get(i).weight;
                
                if (visited[next]) continue;
                pq.add(new Node(next, cost));
            }

        }
        
        return answer;
    }
}

class Node implements Comparable<Node> {
    int start;
    int weight;
    
    public Node (int start, int weight) {
        this.start = start;
        this.weight = weight;
    }
    
    public int compareTo(Node c) {
        return this.weight - c.weight;
    }
}