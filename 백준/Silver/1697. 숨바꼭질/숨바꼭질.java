

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1697/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        boolean[] visited = new boolean[100_001];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node nd = q.poll();
            if (nd.num == m) {
                System.out.println(nd.depth);
                break;
            }

            if (nd.num - 1 >= 0 && !visited[nd.num - 1]) {
                q.add(new Node(nd.num - 1, nd.depth + 1));
                visited[nd.num - 1] = true;
            }
            if (nd.num + 1 <= 100_000 && !visited[nd.num + 1]) {
                q.add(new Node(nd.num + 1, nd.depth + 1));
                visited[nd.num + 1] = true;
            }
            if (nd.num * 2 < 100_001 && !visited[nd.num * 2]) {
                q.add(new Node(nd.num * 2, nd.depth + 1));
                visited[nd.num * 2] = true;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Node {
    int num;
    int depth;

    public Node(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}
