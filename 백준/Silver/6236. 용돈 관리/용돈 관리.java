
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_6236/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int lo = max - 1;
        int hi = sum;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (canOut(mid, arr, m)) hi = mid; // nnny
            else lo = mid;
        }

        System.out.println(hi);

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean canOut(int mid, int[] arr, int m) {
        int cnt = 1;
        int budget = mid;

        for (int num: arr) {
            if (num > budget)  {
                    cnt++;
                    budget = mid;
            }
            budget -= num;
        }

        return cnt <= m;
    }
}
//381
