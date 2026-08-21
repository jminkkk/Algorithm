import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0}; // -> 아래 <- 위로
        
        int r = board.length;
        int c = board[0].length;
        int[][][] dist = new int[r][c][4];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                for (int k = 0; k < 4; k++) {
                    dist[i][j][k] = 25 * 500 * 500;
                }
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0][0] = 0;
        dist[0][0][1] = 0;
        pq.add(new Node(0, 0, 0, 0));
        pq.add(new Node(0, 0, 1, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (canNotGo(nx, ny, r, c, board)) continue;
                
                int cost = 0;
                if (now.dir == i) cost = 100;
                else cost = 600;
                
                if (dist[nx][ny][i] < now.v + cost) continue; // dist[now.x][now.y][i] + cost가 아니라??
                dist[nx][ny][i] = now.v + cost;
                pq.add(new Node(nx, ny, i, dist[nx][ny][i]));
            }
        }
        
        // for (int i = 0 ; i < r; i++) {
        //     for (int j = 0 ; j < c; j++) {
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) answer = Math.min(answer, dist[r - 1][c - 1][i]);
        return answer;
    }
    
    public boolean canNotGo(int x, int y, int r, int c, int[][] board) {
        return x < 0 || y < 0 || x >= r || y >= c || board[x][y] == 1;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int dir;
    int v;
    
    Node(int x, int y, int dir, int v) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.v = v;
    }
    
    public int compareTo(Node o) {
        return Integer.compare(this.v, o.v);
    }
}