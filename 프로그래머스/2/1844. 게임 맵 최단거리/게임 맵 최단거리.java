import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];   
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int distance = p.distance;
            
            if (x == maps.length - 1 && y == maps[0].length - 1) {
                answer = Math.min(distance, answer);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny, maps.length, maps[0].length, maps)) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Point(nx, ny, distance + 1));
                // visited[nx][ny] = false;
            }
        }
        
        if (answer == Integer.MAX_VALUE) answer = - 1;
        return answer;
    }

    public boolean canGo(int x, int y, int n, int m, int[][] maps) {
        return x >= 0 && y >= 0 && x < n && y < m && maps[x][y] == 1;
    }
}

class Point {
    int x;
    int y;
    int distance;
    
    Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}