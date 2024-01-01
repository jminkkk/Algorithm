
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int n, d, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            d = Integer.parseInt(str[1]);
            c = Integer.parseInt(str[2]);
            List<List<Node>> graph = new ArrayList<>();

            for (int j = 0; j < n + 1; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < d; j++) {
                String[] str2 = br.readLine().split(" ");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);
                int s = Integer.parseInt(str2[2]);

                graph.get(b).add(new Node(a, s));
            }

            int[] dist = dijkstra(graph);

            int virusCount = 0;
            int totalSeconds = 0;

            for (int j : dist) {
                if (j != Integer.MAX_VALUE) {
                    virusCount += 1;
                    totalSeconds = Math.max(totalSeconds, j);
                }
            }

            System.out.println(virusCount + " " + totalSeconds);
        }
    }

    private static int[] dijkstra(List<List<Node>> graph) {
        boolean[] computer = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        computer[c] = true;
        dist[c] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(c, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int next = node.next;
            int second = node.second;

            for (int i = 0; i < graph.get(next).size(); i++) {
                Node nextNode = graph.get(next).get(i);

                if (dist[nextNode.next] > second + nextNode.second) {
                    dist[nextNode.next] = second + nextNode.second;
                    queue.add(new Node(nextNode.next, second + nextNode.second));
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node> {
    int next;
    int second;

    public Node(int next, int second) {
        this.next = next;
        this.second = second;
    }

    @Override
    public int compareTo(Node o) {
        return this.second - o.second;
    }
}
