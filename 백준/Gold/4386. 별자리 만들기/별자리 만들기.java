
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_4386/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);

        List<Point> starArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            double x = Double.parseDouble(str[0]);
            double y = Double.parseDouble(str[1]);
            starArr.add(new Point(x, y));
        }

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Point p = starArr.get(i);
            for (int j = i + 1; j < n; j++) {
                Point q = starArr.get(j);
                double xDist = Math.pow(p.x -q.x, 2);
                double yDist = Math.pow(p.y - q.y, 2);
                double dist = Math.sqrt(xDist + yDist);
                graph[i].add(new Node(j, dist));
                graph[j].add(new Node(i, dist));
            }
        }

        List<Integer> mst = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        boolean[] visited = new boolean[n + 1];
        double sum = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.toIdx]) continue;
            visited[now.toIdx] = true;
            sum += now.cost;
            mst.add(now.toIdx);

            if (mst.size() == n) break;

            for (Node next: graph[now.toIdx]) {
                if (visited[next.toIdx]) continue;
                pq.add(next);
            }
        }

        System.out.println(sum);

        bw.flush();
        bw.close();
        br.close();
    }
}


class Node implements Comparable<Node> {
    int toIdx;
    double cost;

    public Node(int toIdx, double cost) {
        this.toIdx = toIdx;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return Double.compare(this.cost, o.cost);
    }
}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
