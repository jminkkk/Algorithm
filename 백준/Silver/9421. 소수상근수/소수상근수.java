import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] isChecked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                if (!isPrime[j]) {
                    continue;
                }
                isPrime[j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                isChecked = new boolean[487];
                if (find(i)) {
                    System.out.println(i);
                }
            }
        }
    }

    private static boolean find(int number) {
        if (number == 1) {
            return true;
        }

        int num = 0;
        String[] str = Integer.toString(number).split("");
        for (String s: str) {
            num += Integer.parseInt(s) * Integer.parseInt(s);
        }

        if (isChecked[num]) {
            return false;
        } else {
            isChecked[num] = true;
        }

        return find(num);
    }
}
