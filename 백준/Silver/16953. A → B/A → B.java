
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_16953/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a, 0));

        while (!q.isEmpty()) {
            Node nd = q.poll();
            if (nd.value == b) {
                System.out.println(nd.cnt + 1);
                return;
            }

            if (nd.value * 2 <= b) {
                q.offer(new Node(nd.value * 2, nd.cnt + 1));
            }

            if (nd.value * 10 + 1 <= b) {
                q.offer(new Node(nd.value * 10 + 1, nd.cnt + 1));
            }
        }

        System.out.println(-1);

        bw.flush();
        bw.close();
        br.close();
    }
}

class Node {
    long value;
    long cnt;

    public Node(long value, long cnt) {
        this.value = value;
        this.cnt = cnt;
    }
}
//bfs
//	Queue<Node> q = new LinkedList<>();
//	q.offer(new Node(a, 0));
//	while (!q.isEmpty()) {
//		Node nd = q.poll();
//		if (nd.value == b) {
//			System.out.println(nd.cnt);
//			return;
//		}
//
//		if (nd.value * 2 <= b) {
//			q.offer(new Node(nd.value * 2, nd.cnt + 1);
//		} else if (nd.value * 10 + 1 <= b) {
//			q.offer(new Node(nd.value * 10 + 1, nd.cnt + 1);
//		}
//	}
//
//	System.out.println(-1);
//430,000,000 503,270,511
