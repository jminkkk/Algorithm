import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int answer = -1;
    static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];
        
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = -1;
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        visited[0][0] = true;
        dis[0][0] = 1;
        q.offer(new Node(0, 0));

        while (!q.isEmpty()) {
            Node nd = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = nd.x + dx[i];
                int ny = nd.y + dy[i];
            
                if (!isAvaliable(n, m, nx, ny, maps)) continue;
        
                visited[nx][ny] = true;
                dis[nx][ny] = dis[nd.x][nd.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }

        return dis[n - 1][m - 1];
    }
    
    private boolean isAvaliable(int n, int m, int x, int y, int[][] maps) {
        return x < n && y < m && x >= 0 && y >= 0 
            && !visited[x][y] && maps[x][y] == 1;
    }
}

class Node {
    int x;
    int y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}