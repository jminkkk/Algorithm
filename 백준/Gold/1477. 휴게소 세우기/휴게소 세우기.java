
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1477/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int l = Integer.parseInt(s[2]);

        s = br.readLine().split(" ");
        int[] arr = new int[n + 2];
        arr[0] = 0;
        arr[n + 1] = l;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }

        int lo = 0;
        int hi = l;

        Arrays.sort(arr);

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (canSatisfied(mid, arr, m, l)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        System.out.println(hi);

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean canSatisfied(int mid, int[] arr, int m, int l) {
        int cnt = 0;

        for (int i = 1; i < arr.length; i++) {
            int distance = arr[i] - arr[i - 1];
            cnt += (distance - 1) / mid;
        }

        return cnt <= m;
    }

}
// 82 201 411 555 622 755 (800)
