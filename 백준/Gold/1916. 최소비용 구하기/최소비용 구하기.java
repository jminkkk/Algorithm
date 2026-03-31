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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1916/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        List<Node>[] graph = new ArrayList[n + 1];// 인접리스트
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            str = br.readLine().split(" ");
            int bus1 = Integer.parseInt(str[0]);
            int bus2 = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            graph[bus1].add(new Node(bus2, cost));
        }

        str = br.readLine().split(" ");
        int start = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > dist[now.pos]) continue;

            for (Node next: graph[now.pos]) {
                int nextCost = now.cost + next.cost;
                if (nextCost >= dist[next.pos]) continue;
                pq.add(new Node(next.pos, nextCost));
                dist[next.pos] = nextCost;
            }
        }

        System.out.println(dist[end]);

        bw.flush();
        bw.close();
        br.close();
    }
}

class Node implements Comparable<Node> {
   int cost;
   int pos;

    public Node(int pos, int cost) {
        this.cost = cost;
        this.pos = pos;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
