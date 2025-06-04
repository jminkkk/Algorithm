import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt() + 1000;
        int ay1 = sc.nextInt() + 1000;
        int ax2 = sc.nextInt() + 1000;
        int ay2 = sc.nextInt() + 1000;

        int bx1 = sc.nextInt() + 1000;
        int by1 = sc.nextInt() + 1000;
        int bx2 = sc.nextInt() + 1000;
        int by2 = sc.nextInt() + 1000;

        int mx1 = sc.nextInt() + 1000;
        int my1 = sc.nextInt() + 1000;
        int mx2 = sc.nextInt() + 1000;
        int my2 = sc.nextInt() + 1000;
        // Please write your code here.
        int maxAC = Math.max(ax1, ax2);
        int maxAR = Math.max(ay1, ay2);

        int maxBC = Math.max(bx1, bx2);
        int maxBR = Math.max(by1, by2);

        int maxMC = Math.max(mx1, mx2);
        int maxMR = Math.max(my1, my2);

        int maxR = Math.max(maxAR, maxBR);
        maxR = Math.max(maxR, maxMR);

        int maxC = Math.max(maxAC, maxBC);
        maxC = Math.max(maxC, maxMC);

        int[][] arr = new int[maxR + 1][maxC + 1];
        for (int r = Math.min(ay1, ay2); r < Math.max(ay1, ay2); r++) {
            for (int c = Math.min(ax1, ax2); c < Math.max(ax1, ax2); c++) {
                arr[r][c] = 1;
            }
        }

        for (int r = Math.min(by1, by2); r < Math.max(by1, by2); r++) {
            for (int c = Math.min(bx1, bx2); c < Math.max(bx1, bx2); c++) {
                arr[r][c] = 1;
            }
        }
        for (int r = Math.min(my1, my2); r < Math.max(my1, my2); r++) {
            for (int c = Math.min(mx1, mx2); c < Math.max(mx1, mx2); c++) {
                arr[r][c] -= 1;
            }
        }
        int cnt = 0;
        for (int r = 0; r < maxR + 1; r++) {
            for (int c = 0; c < maxC + 1; c++) {
                if (arr[r][c] == 1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}