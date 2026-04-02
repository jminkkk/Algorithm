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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_13549/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int[] dist = new int[100_001];
        for (int i = 0; i <= 100_000; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[n] = 0;
        pq.add(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node nd = pq.poll();

            int[][] nextArr = {{nd.pos + 1, nd.cost + 1}
                    , {nd.pos - 1, nd.cost + 1}
                    , {nd.pos * 2, nd.cost}};

            for (int[] next: nextArr) {
                if (next[0] < 0 || next[0] > 100_000) continue;
                if (next[1] >= dist[next[0]]) continue;

                pq.add(new Node(next[0], next[1]));
                dist[next[0]] = next[1];
            }
        }

        System.out.println(dist[k]);

        bw.flush();
        bw.close();
        br.close();
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
        return Integer.compare(this.cost, o.cost);
    }
}
