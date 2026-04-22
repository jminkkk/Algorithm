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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1463/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) dp[i] = Integer.MAX_VALUE;

        dp[n] = 0;

        for (int i = n - 1; i >= 1; i--) {
            if (i * 3 <= n) {
                dp[i] = Math.min(dp[i], dp[i * 3] + 1);
            } 
            
            if (i * 2 <= n) {
                dp[i] = Math.min(dp[i], dp[i * 2] + 1);
            }

            dp[i] = Math.min(dp[i], dp[i + 1] + 1);
        }

        System.out.println(dp[1]);

        bw.flush();
        bw.close();
        br.close();
    }
}
