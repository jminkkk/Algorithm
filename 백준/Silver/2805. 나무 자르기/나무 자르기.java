
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2805/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        long m = Long.parseLong(str[1]);
        int[] arr = new int[n];

        // yyyyn
        int lo = 0;
        int hi = 0;

        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
            hi = Math.max(hi, arr[i]);
        }

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (canCut(arr, m, mid)) lo = mid;
            else hi = mid;
        }

        System.out.println(lo);

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean canCut(int[] arr, long m, int x) {
        long sum = 0;
        for (int num: arr) sum += Math.max(num - x, 0);
        return sum >= m;
    }
}
