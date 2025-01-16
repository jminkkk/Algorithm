import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;


class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        str = br.readLine().split(" ");
        Queue<Node> queue = new LinkedList<>();
        int x = Integer.parseInt(str[0]) - 1;
        int y = Integer.parseInt(str[1]) - 1;

        int[][] arr = new int[n][m];
        int[][] len = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            Arrays.fill(len[i], -1);
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        Map<Integer, Integer> lenAndSum = new TreeMap<>();
        queue.add(new Node(x, y, 0));
        lenAndSum.put(0,  arr[x][y]);
        visited[x][y] = true;
        len[x][y] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                int ndepth = node.depth + 1;
                len[nx][ny] = ndepth;
                queue.add(new Node(nx, ny, ndepth));

                lenAndSum.put(ndepth, lenAndSum.getOrDefault(ndepth, 0) + arr[nx][ny]);
            }
        }
        int max = 0;
        int sum = 0;
        for (Entry<Integer, Integer> entry : lenAndSum.entrySet()) {
            sum += entry.getValue();
            max = Math.max(sum - (entry.getKey() * c), max);
        }
        System.out.println(max);
    }
}

class Node {
    int x;
    int y;
    int depth;

    public Node(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
//2 2 2
//2 2
//0 1
//1 2
