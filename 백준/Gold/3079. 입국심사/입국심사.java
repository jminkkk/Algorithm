
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

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] arr = new int[n];

        int max = 0;
        for (int i = 0;  i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long lo = 0;
        long hi = (long) m * max;
        while (lo + 1 < hi) { // nnny
            long mid = (lo + hi) / 2;

            if (canPermit(mid, arr, m)) {
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

    public boolean canPermit(long mid, int[] arr, long m) {
        long cnt = 0;
        for (int num : arr) {
            cnt += mid / num;
            if (cnt >= m) return true;
        }
        return cnt >= m;
    }
}
