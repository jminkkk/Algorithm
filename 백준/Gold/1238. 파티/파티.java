import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java//input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int x = Integer.parseInt(str[2]);

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        ArrayList<Node>[] reverseGraph = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        int[] reverseDist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            reverseDist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            graph[from].add(new Node(to, cost));
            reverseGraph[to].add(new Node(from, cost));
        }

        dijkstra(x, dist, graph);
        dijkstra(x, reverseDist, reverseGraph);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            max = Math.max(max, dist[i] + reverseDist[i]);
        }

        System.out.println(max);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int x, int[] dist, ArrayList<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.pos] < now.cost) continue;

            for (Node next: graph[now.pos]) {
                int nextCost = next.cost + now.cost;

                if (nextCost >= dist[next.pos]) continue;
                pq.add(new Node(next.pos, nextCost));
                dist[next.pos] = nextCost;
            }
        }
    }
}

class Node implements Comparable<Node> {
    int pos;
    int cost;

    public Node(int pos, int cost) {
        this.pos = pos;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
