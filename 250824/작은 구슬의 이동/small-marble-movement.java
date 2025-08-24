import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt() - 1;
        int C = sc.nextInt() - 1;
        String D = sc.next();
        // Please write your code here.

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        
        if (D.equals("U")) dir = 1;
        else if (D.equals("D")) dir = 3;
        else if (D.equals("R")) dir = 0;
        else if (D.equals("L")) dir = 2;

        for (int i = 0; i < T; i++) {
            int nr = R + dx[dir];
            int nc = C + dy[dir];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                dir = (dir + 2) % 4;
            } else {
                R += dx[dir];
                C += dy[dir];
            }
        }

        System.out.println((R + 1) + " " + (C + 1));
    }
}