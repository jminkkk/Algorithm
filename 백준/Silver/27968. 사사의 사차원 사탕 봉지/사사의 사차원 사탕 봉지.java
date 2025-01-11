import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        // 아이에게 사탕
        str = br.readLine().split(" ");
        long[] sum = new long[m];
        sum[0] = Integer.parseInt(str[0]);
        for (int i = 1; i < m; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(str[i]);
        }

        // 1 2 3 ...
        for (int i = 0; i < n; i++) {
            long k = Long.parseLong(br.readLine());
            bs(k, sum);
        }
    }

    private static void bs(long now, long[] arr) {
        if (now > arr[arr.length - 1]) {
            System.out.println("Go away!");
            return;
        }

        if (now <= arr[0]) {
            System.out.println(1);
            return;
        }

        int lo = 0;
        int hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == now) { // 불불불 가가
                System.out.println(mid + 1);
                return;
            } else if (arr[mid] < now) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        System.out.println(lo + 2);
    }
}
// 개수별 합 구해놓고

// m 들어왔을 때
// 이진탐색

