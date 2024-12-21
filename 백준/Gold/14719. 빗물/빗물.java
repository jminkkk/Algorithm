import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int h = Integer.parseInt(str[0]);
        int w = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");

        arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        if (w == 1) {
            System.out.println(0);
            return;
        }

        int sum = 0;

        for (int i = 0; i < w; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            for (int j = i + 1;  j < w; j++) {
                right = Math.max(right, arr[j]);
            }

            if (arr[i] < left && arr[i] < right) {
                sum += Math.min(left, right) - arr[i];
            }
        }

        System.out.println(sum);
    }
}
