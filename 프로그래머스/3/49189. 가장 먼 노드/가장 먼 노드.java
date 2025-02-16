import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0] - 1;
            int b = edge[i][1] - 1;
            
            list[a].add(b);
            list[b].add(a);
        }
        
        int[] finalN = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0] = true;
        finalN[0] = 0;
        
        int max = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();
            List<Integer> nums = list[node.num];
            
            for (int i = 0; i < nums.size(); i++) {
                int close = nums.get(i);
                if (visited[close]) continue;
                q.add(new Node(close, node.depth + 1));
                visited[close] = true;
                finalN[close] = node.depth + 1;
                max = Math.max(max, node.depth + 1);
            }
        }
        
        for (int i = 0; i < finalN.length; i++) {
            if (finalN[i] == max) answer++;
        }
        
        return answer;
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