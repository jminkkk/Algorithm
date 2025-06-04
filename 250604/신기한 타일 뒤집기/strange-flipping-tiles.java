import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[200_001];
        int now = 100_000;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            for (int j = 0; j < x; j++) {
                if (d == 'R') {
                    if (j != 0) now++;
                    arr[now] = 1;
                } else {
                    if (j != 0) now--;
                    arr[now] = 2;
                }
            }
        }
        int b = 0;
        int w = 0;
        for (int i = 0; i < 200_001; i++) {
            if (arr[i] == 1) b++;
            if (arr[i] == 2) w++;
        }
        System.out.println(w + " " + b);
    }
}