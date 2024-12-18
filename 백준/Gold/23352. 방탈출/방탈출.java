import java.util.ArrayList;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m, maxLen, maxSum;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr = new int[n][m];
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] != 0) {
                    points.add(new Point(i, j));
                }
            }
        }

        maxLen = 0;
        maxSum = 0;

        for (Point point : points) {
            bfs(point);
        }

        System.out.println(maxSum);
    }

    private static void bfs(Point start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start.x, start.y, 0));
        boolean[][] visited = new boolean[n][m];
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            boolean extended = false;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }
                if (arr[nx][ny] != 0) {
                    extended = true;
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, node.dist + 1));
                }
            }

            if (!extended) {
                if (node.dist > maxLen) {
                    maxLen = node.dist;
                    maxSum = arr[start.x][start.y] + arr[node.x][node.y];
                } else if (node.dist == maxLen) {
                    maxSum = Math.max(maxSum, arr[start.x][start.y] + arr[node.x][node.y]);
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
