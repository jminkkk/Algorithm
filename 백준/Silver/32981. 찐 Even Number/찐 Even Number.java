import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int digit = Integer.parseInt(br.readLine());
            if (digit == 1) {
                System.out.println(5);  // 1자리수: 0,2,4,6,8
                continue;
            }
            long ans = (4L * power(5, digit - 1)) % MOD;
            System.out.println(ans);
        }
    }

    private static long power(long a, long b) {
        if (b == 0) return 1;
        if (b % 2 == 1) return (power(a, b-1) * a) % MOD;
        
        long half = power(a, b/2) % MOD;
        return (half * half) % MOD;
    }
}