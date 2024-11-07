import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine();
        long n = Long.parseLong(nStr);

        int len = nStr.length();

        for (long i = n - 9 * len ; i < n; i++) {
            long num = i;
            long sum = i;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
