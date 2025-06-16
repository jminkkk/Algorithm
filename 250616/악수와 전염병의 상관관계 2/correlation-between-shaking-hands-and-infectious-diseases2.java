import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();
        int[][] shakes = new int[T][3];

        boolean[] virus = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt();
            shakes[i][1] = sc.nextInt() - 1;
            shakes[i][2] = sc.nextInt() - 1;

            pq.add(new Node(shakes[i][0], shakes[i][1], shakes[i][2]));
        }
        
        int[] cnt = new int[N];
        virus[P - 1] = true;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (!virus[node.x] && !virus[node.y]) continue;
            if (virus[node.x] && cnt[node.x] >= K && virus[node.y] && cnt[node.y] >= K) continue;

            if (virus[node.x] && cnt[node.x] < K && virus[node.y] && cnt[node.y] < K) {
                cnt[node.x]++;
                cnt[node.y]++;
                continue;
            }

            if (virus[node.x] && cnt[node.x] < K) {
                cnt[node.x]++;
                 virus[node.y] = true;
            }

            if (virus[node.y] && cnt[node.y] < K) {
                cnt[node.y]++;
                virus[node.x] = true;
            }
        }

        String answer = "";
        for (int i = 0; i < N; i++) {
            if (virus[i]) answer += "1";
            else answer += "0";
        }
        System.out.println(answer);
    }
}
// N명 개발자, t초에  x- y, K번 악수, 

class Node implements Comparable<Node> {
    int t;
    int x;
    int y;

    public int compareTo(Node n) {
        return t - n.t;
    }    

    Node(int t, int x, int y) {
        this.t = t; 
        this.x = x;
        this.y = y;
    }
}