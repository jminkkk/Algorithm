import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int x = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        int max = 0;
        int count = 1;
        for (int j = 0; j < x; j++) {
            max += Integer.parseInt(str[j]);
        }

        int sum = max;
        for (int i = x; i < n; i ++) {
            sum = sum - Integer.parseInt(str[i - x]) + Integer.parseInt(str[i]);
            if (sum == max) {
                count++;
            } else if (sum > max) {
                max = sum;
                count = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(count);
    }
}
