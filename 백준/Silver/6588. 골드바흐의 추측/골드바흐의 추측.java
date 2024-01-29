
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1_000_000 + 1];
        for (int i = 2; i <= 1_000_000; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= 1_000_000; i++) {
            for (int j = i * 2; j <= 1_000_000; j += i) {
                isPrime[j] = false;
            }
        }

        int n = Integer.parseInt(br.readLine());
        while (true) {
            if (n == 0) {
                break;
            }

            boolean isGoldbach = false;
            for (int i = 1; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    isGoldbach = true;
                    break;
                }
            }

            if (!isGoldbach) {
                System.out.println("Goldbach's conjecture is wrong.");
            }

            n = Integer.parseInt(br.readLine());
        }
    }
}
