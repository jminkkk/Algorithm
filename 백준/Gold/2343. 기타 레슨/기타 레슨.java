
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2343/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] arr = new int[n];

        int max = 0;
        str = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
            max = Math.max(max, arr[i]);
        }

        int lo = 0;
        int hi = max * n;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (canRecord(mid, m, arr)) hi = mid;
            else lo = mid;
        }

        System.out.println(hi);

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean canRecord(int mid, int m, int[] arr) {
        int cnt = 1;
        int sum = 0;
        for (int num: arr) {
            if (num > mid) return false;
            if (sum + num <= mid) sum += num;
            else {
                cnt++;
                sum = num;
            }
        }

        return cnt <= m;
    }
}
