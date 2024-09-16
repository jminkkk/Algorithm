
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        long m = Integer.parseInt(str[1]);

        str = bufferedReader.readLine().split(" ");

        int start = 0;
        long sum = 0;
        long max = 0;
        for (int end = 0; end < n; end++) {
            sum += Long.parseLong(str[end]);
            while (sum > m && start <= end) {
                sum -= Long.parseLong(str[start++]);
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
