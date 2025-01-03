import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] arr = new int[n];
        int[] sum = new int[n + 1];

        str = br.readLine().split(" ");
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = Integer.parseInt(str[i - 1]);
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        int count = 0;
        int start = 0, end = 0;

        while (end <= n) {
            int now = sum[end] - sum[start];
            if (now == m) {
                count++;
                start++;
            } else if (now < m){
                end++;
            } else {
                start++;
            }
        }

        System.out.println(count);
    }
}
