import java.util.*;

class Solution {
    public  int solution(int[][] maps) {
        int xLength = maps.length;
        int yLength = maps[0].length;

        boolean[][] visited = new boolean[xLength][yLength];
        
        int shortestPath = bfs(0, 0, maps, visited, xLength, yLength);

        return shortestPath == 0 ? -1 : shortestPath;
    }

    public  int bfs(int x, int y, int[][] maps, boolean[][] visited, int xLength, int yLength) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 1)); // 시작점의 count를 1로 설정

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == xLength - 1 && now.y == yLength - 1) {
                return now.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < xLength && ny >= 0 && ny < yLength && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, now.count + 1));
                }
            }
        }
        return 0; // 도달할 수 없는 경우
    }
}

class Point {
    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
