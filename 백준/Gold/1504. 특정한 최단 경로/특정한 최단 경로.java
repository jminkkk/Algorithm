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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1504/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);

        List<Node>[] graph = new ArrayList[n + 1];// 인접리스트
        for (int i = 1; i <= n; i++) { // 1_000
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= e; i++) {
            str = br.readLine().split(" ");
            int bus1 = Integer.parseInt(str[0]);
            int bus2 = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            graph[bus1].add(new Node(bus2, cost));
            graph[bus2].add(new Node(bus1, cost));
        }

        str = br.readLine().split(" ");
        int v1 = Integer.parseInt(str[0]);
        int v2 = Integer.parseInt(str[1]);

        long firstPath = (long) dijkstra(1, v1, graph) + dijkstra(v1, v2, graph) + dijkstra(v2, n, graph);
        long secondPath = (long) dijkstra(1, v2, graph) + dijkstra(v2, v1, graph) + dijkstra(v1, n, graph);

        long min = Math.min(firstPath, secondPath);

        if (min >= Integer.MAX_VALUE) min = -1;
        System.out.println(min);

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end, List<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[graph.length];
        for (int i = 1; i < graph.length; i++) { // 1_000
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) { // 100_000
            Node now = pq.poll();

            if (now.cost > dist[now.pos]) continue;

            for (Node next: graph[now.pos]) {
                int nextCost = now.cost + next.cost;
                if (nextCost >= dist[next.pos]) continue;
                pq.add(new Node(next.pos, nextCost));
                dist[next.pos] = nextCost;
            }
        }

        return dist[end];
    }
}

class Node implements Comparable<Node> {
    int pos;
    int cost;

    public Node(int pos, int cost) {
        this.pos = pos;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

