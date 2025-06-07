import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[][] arr = new int[201][201];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt() + 100;
            y[i] = sc.nextInt() + 100;

            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    arr[y[i] + r][x[i] + c] = 1;
                }
            }
        }
        
        int cnt = 0;
        for (int r = 0; r < 201; r++) {
            for (int c = 0; c < 201; c++) {
                if (arr[r][c] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}