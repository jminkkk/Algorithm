
/**
 * Author: nowalex322, Kim HyeonJae
 */

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
       //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_11047/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        } // 10인 경우 4 3

        int cnt = 0;
        for (int i = n - 1; i >= 0;  i--) {
            if (k == 0) continue;

            cnt += k / coin[i];
            k %= coin[i];
        }

        System.out.println(cnt);

        bw.flush();
        bw.close();
        br.close();
    }
}
