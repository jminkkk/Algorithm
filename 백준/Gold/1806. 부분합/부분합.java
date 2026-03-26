
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

        int len = Integer.MAX_VALUE;

        int start = 0;
        int end = 1;
        while (start <= end && end <= n) {
            if (sum[end] - sum[start] < s) {
                end++;
                continue;
            }

            if (end == start) {
                len = 1;
                break;
            }

            len = Math.min(len, end - start);
            start++;
        }

        if (len == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(len);
        }

        //1. sum[end] - sum[start] ≥ S
        //    1. len = Math.min(len, end - start)
        //    2. start++
        //2. sum[end] - sum[start] < S
        //    1. end++

        bw.flush();
        bw.close();
        br.close();
    }
}
//10 21
//20 1 2 3 4 5 6 7 8 9
//20 21 23 26 30 37 45 54 64
