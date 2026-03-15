
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1654/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] kArr = new int[k];
        for (int i = 0; i < k; i++) {
            kArr[i] = Integer.parseInt(br.readLine());
        }

        long kSum = 0;
        for (int i = 0; i < kArr.length; i++) {
            kSum += kArr[i];
        }

        long lo = 1;
        long hi = kSum / n + 1; // O(log2^31)
        while (lo  + 1 < hi) { // yyyn -> y
            long mid = (lo + hi) / 2;

            if (canCut(mid, n, kArr)) lo = mid;
            else hi = mid;
        }

        System.out.println(lo);

        bw.flush();
        bw.close();
        br.close();
    }


    public boolean canCut(long x, int n, int[] arr) {
        long cnt = 0;
        for (int now: arr) cnt += now / x;
        return cnt >= n;
    }
}
//4 11
//802
//743
//457
//539

