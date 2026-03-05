
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
        int k = Integer.parseInt(str[1]);

        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        }

        int[] depths = new int[100_000 + 1];
        int[] count = new int[100_000 + 1];

        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        for (int p = 0; p <= 100_000; p++) depths[p] = -1;
        depths[n] = 0;
        count[n] = 1;

        while (!q.isEmpty()) {
            int p = q.poll();

            int[] next = new int[]{p + 1, p - 1, p * 2};
            for (int d : next) {
                if (d < 0 || d > 100_000) continue;

                if (depths[d] == -1) {
                    depths[d] = depths[p] + 1;
                    count[d] = count[p];
                    q.add(d);
                } else if (depths[d] == depths[p] + 1) {
                    count[d] += count[p];
                }
            }
        }

        System.out.println(depths[k]);
        System.out.println(count[k]);

        bw.flush();
        bw.close();
        br.close();
    }
}
