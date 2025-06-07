import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt() + 1000;
        int rect1_y1 = sc.nextInt() + 1000;
        int rect1_x2 = sc.nextInt() + 1000;
        int rect1_y2 = sc.nextInt() + 1000;

        int rect2_x1 = sc.nextInt() + 1000;
        int rect2_y1 = sc.nextInt() + 1000;
        int rect2_x2 = sc.nextInt() + 1000;
        int rect2_y2 = sc.nextInt() + 1000;
        
        int[][] arr = new int[rect1_y2 + 1][rect1_x2 + 1];
        for (int i = rect1_y1; i <= rect1_y2; i++) {
            for (int j = rect1_x1; j <= rect1_x2; j++) {
                arr[i][j] = 1;
            }
        }

        for (int i = rect2_y1; i <= rect2_y2; i++) {
            for (int j = rect2_x1; j <= rect2_x2; j++) {
                if (i <= rect1_x2 &&  j <= rect1_x2) arr[i][j] = 0;
            }
        }
        
        int cnt = 0;
        for (int i = 0; i <= rect1_y2; i++) {
            for (int j = 0; j <= rect1_x2; j++) {
                if (arr[i][j] == 1) cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}