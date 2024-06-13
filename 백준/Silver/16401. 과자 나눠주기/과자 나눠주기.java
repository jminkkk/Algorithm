
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int arr[];
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 과자를 a 길이로 잘랐을 때 다 먹기 가능?

        int lo = 0;
        int hi = 1_000_000_000 + 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (canEat(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        System.out.println(lo);
    }

    private static boolean canEat(int x) {
        int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            count += arr[i] / x;
        }
        return count >= M;
    }
}
