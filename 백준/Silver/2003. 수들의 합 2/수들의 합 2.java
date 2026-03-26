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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java//input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(str[i - 1]);
            sum[i] = sum[i - 1] + arr[i];
        }

        int start = 0;
        int end = 1;

        int cnt = 0;
        while (start <= end && end <= n) {
            if (sum[end] - sum[start] < s) {
                end++;
                continue;
            }

            if (sum[end] - sum[start] > s) {
                start++;
                continue;
            }

            cnt++;
            end++;
        }

        System.out.println(cnt);

        bw.flush();
        bw.close();
        br.close();
    }
}
