import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k, ans;
    static int[] kArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kArr = new int[k];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            kArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(kArr);
        dfs(0);
        System.out.println(ans);

    }

    public static void dfs(int num) {
        if(num >  n) return;

        if(ans < num) ans = num;

        for (int i = k - 1; i >= 0; i--) {
            dfs(num * 10 + kArr[i]);
        }
    }
}