import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        
        int[][] arr = new int[n][100];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            arr[i][x1[i]] = 1;
            arr[i][x2[i]] = -1;
        }

        int max = 0;
        for (int i = 1; i < 100; i++) {
            int now = 0;
            for (int j = 0; j < n; j++) {
                arr[j][i] += arr[j][i - 1];
                now += arr[j][i];
            }

            max = Math.max(max, now);
        }

        System.out.println(max);
    }
}