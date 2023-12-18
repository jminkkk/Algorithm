
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int L = Integer.parseInt(arr[0]);
        int W = Integer.parseInt(arr[1]);
        int sum = L + W;

        int l = 1;
        int w = 1;

        for (int i = 1; i < L; i++) {
            int j = sum / i;
            if (i * j == sum && (i - 2) * (j - 2) == W) {
                l = i;
                w = j;
                break;
            }
        }

        if (l < w) {
            int temp = l;
            l = w;
            w = temp;
        }

        System.out.println(l + " " + w);
    }
}
