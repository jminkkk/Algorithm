
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1644/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);

        boolean[] isNotPrime = new boolean[4_000_000 + 1];

        isNotPrime[1] = true;
        for (int i = 2; i < 4_000_000; i++) {
            if (isNotPrime[i]) continue;

            for (int j = 2 * i; j <= 4_000_000; j += i) {
                if (isNotPrime[j]) continue;
                isNotPrime[j] = true;
            }
        }

        int[] sum = new int[4_000_000 + 1];
        int pre = sum[0];
        for (int i = 2; i <= 4_000_000; i++) {
            if (!isNotPrime[i]) {
                sum[i] = pre + i;
                pre = sum[i];
            }
        }

        int cnt = 0;
        int left = 0;
        int right = 2;

        while (left < right && right <= n) {
            if (sum[right] - sum[left] <= n) {
                if (sum[right] - sum[left] == n) cnt++;
                while (true) {
                    right++;
                    if (right > 4000_000 || !isNotPrime[right]) break;
                }
                continue;
            }

            if (sum[right] - sum[left] > n) {
                while (true) {
                    left++;
                    if (left > 4000_000 || !isNotPrime[left]) break;
                }
            }
        }

        System.out.println(cnt);

        bw.flush();
        bw.close();
        br.close();
    }
}
