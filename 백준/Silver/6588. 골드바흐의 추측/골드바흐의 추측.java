
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1_000_000 + 1];

        for (int i = 2; i <= 1_000_000; i++) {
            isPrime[i] = true;
        }

        // i의 배수들 제거
        for (int i = 2; i <= 1_000_000; i++) {
            for (int j = i * 2; j <= 1_000_000; j += i) {
                if (!isPrime[j]) {
                    continue;
                }
                isPrime[j] = false;
            }
        }

        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                break;
            }

            boolean isDone = false;
            for (int i = 2; i <= number / 2; i++) {
                if (isPrime[i] && isPrime[number - i]) {
                    System.out.println(number + " = " + i + " + " + (number - i));
                    isDone = true;
                    break;
                }
            }

            if (!isDone) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
