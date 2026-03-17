import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1300/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (k  == 1) {
            System.out.println(1);
            return;
        }

        long lo = 1;
        long hi = (long) n * n;

        while (lo + 1 < hi) { // nnnny
            long mid = (lo + hi) / 2;

            if (canFind(n, mid, k)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        System.out.println(hi);
        bw.flush();
        bw.close();
        br.close();
    }

    public boolean canFind(int n, long x, int k) {
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += Math.min(x/i, n);
        }

        return cnt >= k;
    }
}
