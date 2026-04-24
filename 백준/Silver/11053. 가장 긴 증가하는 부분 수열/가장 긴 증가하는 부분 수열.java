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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_11053/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int now = Arrays.binarySearch(dp, 0, idx, arr[i]); // lower_bound
            if (now < 0) now = -(now + 1);

            dp[now] = arr[i];

            if (now == idx) idx++;
        }

        System.out.println(idx);

        bw.flush();
        bw.close();
        br.close();
    }
}
