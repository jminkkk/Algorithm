import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        int[][] arr = new int[201][201];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + 100;
            y1[i] = sc.nextInt() + 100;
            x2[i] = sc.nextInt() + 100;
            y2[i] = sc.nextInt() + 100;

            for (int r = Math.min(y1[i], y2[i]); r < Math.max(y1[i], y2[i]); r++) {
                for (int c = Math.min(x1[i], x2[i]); c < Math.max(x1[i], x2[i]); c++) {
                    arr[r][c] = 1;
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (arr[i][j] == 1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}