import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max = 0;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        Queue<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] == 2) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            arr[node.x][node.y] = node.dis;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (arr[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                queue.add(new Node(nx, ny, node.dis + 1));
                visited[nx][ny] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j] != 0) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print("0 ");
                    }
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

class Node {
    int x;
    int y;
    int dis;

    public Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
