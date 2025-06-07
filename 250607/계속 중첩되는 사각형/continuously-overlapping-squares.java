import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    
        int[][] arr = new int[201][201];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() + 100;
            int y1 = sc.nextInt() + 100;
            int x2 = sc.nextInt() + 100;
            int y2 = sc.nextInt() + 100;

            for (int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) {
                    if (i % 2 == 0) arr[r][c] = 0;
                    else arr[r][c] = 1;
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