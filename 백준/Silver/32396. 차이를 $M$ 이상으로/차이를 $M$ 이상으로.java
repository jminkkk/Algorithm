import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long n = Long.parseLong(str[0]);
        long m = Long.parseLong(str[1]);

        str = br.readLine().split(" ");
        long[] arr = new long[(int) n];

        for (int i = 0; i < str.length; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        
        long count = 0;
        for (int i = 1; i < str.length; i ++) {
            long num = arr[i];
            long pre = arr[i - 1];

            if (Math.abs(num - pre) < m) {
                count++;
                arr[i] = Long.MAX_VALUE;
            }
        }

        System.out.println(count);
    }
}
// 1 5 2 6 3 10 7 11 1
