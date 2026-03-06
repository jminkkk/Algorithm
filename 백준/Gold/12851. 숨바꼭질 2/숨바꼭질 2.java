
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

        int[] cnt = new int[100_001]; // 각 위치에 도달할 때 최소 연산으로 온 경우의 수
        int[] opers = new int[100_001]; // 각 위치에 도달할 때 최소 연산 수
        boolean[] visited = new boolean[100_001];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        cnt[n] = 1;
        opers[n] = 0;
        visited[n] = true;

        while (!q.isEmpty()) {
            int nw = q.poll();

            int[] next = new int[]{nw + 1, nw - 1, nw * 2};

            for (int i = 0; i < next.length; i++) {
                if (next[i] < 0 || next[i] > 100_000)
                    continue;

                if (!visited[next[i]]) {
                    q.add(next[i]);
                    cnt[next[i]] += cnt[nw];
                    visited[next[i]] = true;
                    opers[next[i]] = opers[nw] + 1;
                } else if (opers[nw] + 1 == opers[next[i]]) {
                    cnt[next[i]] += cnt[nw];
                }
            }
        }

        System.out.println(opers[m]);
        System.out.println(cnt[m]);

        bw.flush();
        bw.close();
        br.close();
    }
}
