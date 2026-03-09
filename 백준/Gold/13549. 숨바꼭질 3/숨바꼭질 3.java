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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_12851/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int dis[] = new int[100_001]; // 최단 연산 수
        int cnt[] = new int[100_001]; // 최단 연산 경로 수

        for (int i = 0; i < 100_001; i++) {
            dis[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        dis[n] = 0;
        cnt[n] = 1;

        while (!q.isEmpty()) {
            int nd = q.poll();
            int[] nw = new int[]{nd - 1, nd + 1, nd * 2};
            int[] gap = new int[]{1, 1, 0};

            for (int i = 0; i < 3; i++) {
                int next = nw[i];
                int gapNext = gap[i];
                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (dis[next] == -1) { // 최초 방문
                    if (i == 2) dis[next] = dis[nd];
                    else dis[next] = dis[nd] + 1;

                    cnt[next] = cnt[nd];
                    q.add(next);
                } else if (dis[next] == dis[nd] + gapNext) { // 방문은 했으나, 최단 추가
                    dis[next] = dis[nd] + gapNext;
                    cnt[next] += cnt[nd];
                } else if (dis[next] > dis[nd] + gapNext) { // 방문은 했으나, 지금이 새로운 최단
                    dis[next] = dis[nd] + gapNext;
                    cnt[next] = cnt[nd];
                }
            }
        }

        System.out.println(dis[m]);

        bw.flush();
        bw.close();
        br.close();
    }
}
