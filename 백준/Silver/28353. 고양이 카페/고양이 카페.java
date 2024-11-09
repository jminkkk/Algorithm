import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        long k = Long.parseLong(str[1]);

        str = br.readLine().split(" ");
        long[] arr = new long[n];

        for (int i = 0; i < str.length; i++) {
            arr[i] = Long.parseLong(str[i]);
        }

        Arrays.sort(arr);
        int count = 0;
        for (int start = 0, end = n - 1; start < end; start++) {
            long sum = arr[start] + arr[end];
            if (sum > k) {
                end--;
                start--;
            } else {
                count++;
                end--;
            }
        }
        System.out.println(count);
    }
}
