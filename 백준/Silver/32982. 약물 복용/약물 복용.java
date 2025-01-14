import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        int[] a = new int[2];
        int[] b = new int[2];
        int[] c = new int[2];
        a[0] = Integer.parseInt(str[0]);
        a[1] = Integer.parseInt(str[1]);
        b[0] = Integer.parseInt(str[2]);
        b[1] = Integer.parseInt(str[3]);
        c[0] = Integer.parseInt(str[4]);
        c[1] = Integer.parseInt(str[5]);

        int t = a[1];

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                t += k;
                if (t < 1440) {
                    System.out.println("NO");
                    return;
                }
                t %= 1440;
                if (t < a[0]) {
                    System.out.println("NO");
                    return;
                }
                t = Math.min(t, a[1]);
            }

            t += k;
            if (t >= b[0]) {
                t = Math.min(t, b[1]);
            } else {
                System.out.println("NO");
                return;
            }

            t += k;
            if (t >= c[0]) {
                t = Math.min(t, c[1]);
            } else {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");
    }
}
