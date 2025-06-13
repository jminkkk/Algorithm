import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Please write your code here.
        int[] a = new int[1_000_001];
        int[] b = new int[1_000_001];
        
        int now = 0;

        for (int i = 0; i < n; i++) {
            String d = sc.next();
            int t = sc.nextInt();

            for (int j = 0; j < t; j++) {
                if (now == 0) {
                    if (d.equals("L")) a[now++] = -1;
                    else a[now++] = 1;
                    continue;
                }

                int offset = d.equals("L") ? -1 : 1;
                a[now] = a[now - 1] + offset;
                now++;
            }
        }

        now = 0;
        boolean changed = false;
        int answer = -1;
        for (int i = 0; i < m; i++) {
            String d = sc.next();
            int t = sc.nextInt();

            for (int j = 0; j < t; j++) {
                if (i == 0 && j == 0) {
                    if (d.equals("L")) b[now++] = -1;
                    else b[now++] = 1;

                    if (!changed && a[0] == b[0]) {
                        answer = 0;
                        changed = true;
                    }

                    continue;
                }

                int offset = d.equals("L") ? -1 : 1;
                b[now] = b[now - 1] + offset;

                if (!changed && a[now] == b[now]) {
                    answer = now;
                    changed = true;
                }
                now++;
            }
        }

        System.out.println(answer + 1);
    }
}