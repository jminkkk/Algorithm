
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_4485/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 1;
        while (true) {
            String[] str = br.readLine().split(" ");
            if (str[0].equals("0")) break;

            int n = Integer.parseInt(str[0]);
            int[][] arr = new int[n][n];
            int[][] dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }


            System.out.println("Problem " + cnt++ + ": " + dijkstra(n, arr, dist));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int dijkstra(int n, int[][] arr, int[][] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        dist[0][0] = arr[0][0];

        while (!pq.isEmpty()) {
            Node nd = pq.poll();

            if (dist[nd.x][nd.y] < nd.cost) continue;

            for (int i = 0; i < 4; i++) {
                int nx = nd.x + dx[i];
                int ny = nd.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                int nCost = dist[nd.x][nd.y] + arr[nx][ny];
                if (dist[nx][ny] <= nCost) continue;

                pq.add(new Node(nx, ny, nCost));
                dist[nx][ny] = nCost;
            }
        }
        return dist[n - 1][n - 1];
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
