
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1753/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int V = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1];
        ArrayList<Node>[] graph = new ArrayList[V + 1];

        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        str = br.readLine().split(" ");
        int nw = Integer.parseInt(str[0]);

        for (int i = 0; i < e; i++) {
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);
            graph[u].add(new Node(v, w));
//            graph[v].add(new Node(u, w));
        }

        pq.add(new Node(nw, 0));
        dist[nw] = 0;

        while (!pq.isEmpty()) {
            Node nd = pq.poll();

            if (nd.cost > dist[nd.now]) continue; // 쓰레기값

            for (Node next : graph[nd.now]) {
                int nextCost = nd.cost + next.cost; // 지금 노드까지의 최단 거리 + 연결된 노드의 거리

                if (nextCost > dist[next.now]) {
                    continue;
                }

                pq.add(new Node(next.now, nextCost));
                dist[next.now] = nextCost;
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Node implements Comparable<Node> {
    int now;
    int cost;

    public Node(int now, int cost) {
        this.now = now;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
