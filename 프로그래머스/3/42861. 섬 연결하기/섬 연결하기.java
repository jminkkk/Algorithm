import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        boolean[][] connect = new boolean[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        int answer = 0;
        
        for (int[] arr: costs) {
            connect[arr[0]][arr[1]] = true;
            connect[arr[1]][arr[0]] = true;
            answer += arr[2];
            
            pq.add(new Node(arr[0], arr[1], arr[2]));
        }
        
        while (!pq.isEmpty()) {
            Node nd = pq.poll();

            connect[nd.nd1][nd.nd2] = false;
            connect[nd.nd2][nd.nd1] = false;

            if (canRemove(nd, connect)) answer -= nd.cost; // 제거해도 된다면 제거
            else { // 제거 불가능이면 원복
                // System.out.println(nd.nd1 + " " + nd.nd2 + " " + nd.cost);
                connect[nd.nd1][nd.nd2] = true;
                connect[nd.nd2][nd.nd1] = true;    
            }            
        }
        
        return answer;
    }
    
    public boolean canRemove(Node nd, boolean[][] connect) {
        int cnt = 0;
        boolean[] visited = new boolean[connect.length];
        
        for (int i = 0; i < connect.length; i++) {
            if (visited[i]) continue;
            
            cnt++;
            visited[i] = true;
            dfs(i, connect, visited);
        }
        
        return cnt == 1; // 덩어리 몇개인지 파악
    }
    
    public void dfs(int cur, boolean[][] connect, boolean[] visited) {        
        for (int i = 0; i < connect.length; i++) {
            if (i == cur) continue; // 자기 자신이랑 연결 불가능
            
            if (!connect[cur][i] || visited[i]) continue; // 연결 안되어있는 노드거나 이미 방문면 무시
            
            visited[i] = true;
            dfs(i, connect, visited);
        }
    }
}

class Node implements Comparable<Node> {
    int cost;
    int nd1;
    int nd2;
    
    Node (int nd1, int nd2, int cost) {
        this.cost = cost;
        this.nd1 = nd1;
        this.nd2 = nd2;
    }
    
    public int compareTo(Node nd) {
        return nd.cost - this.cost;
    }
}