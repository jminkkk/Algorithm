import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];

        int[] A = new int[1_000_001];
        int[] B = new int[1_000_001];

        int nowA = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            
            for (int j = 0; j < a[i][1]; j++) {
                if (nowA == 0) {
                    A[nowA++] = a[i][0];
                    continue;
                }
                
                A[nowA] = A[nowA - 1] + a[i][0];
                nowA++;
            }
        }
        
        int nowB = 0;
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();

            for (int j = 0; j < b[i][1]; j++) {
                if (nowB == 0) {
                    B[nowB++] = b[i][0];
                    continue;
                }
                
                B[nowB] = B[nowB - 1] + b[i][0];
                nowB++;
            }
        }

        if (nowA > nowB) {
            for (int i = nowB - 1; i < nowA; i++) A[i] = A[nowA - 1];
        } else {
            for (int i = nowA - 1; i < nowB; i++) B[i] = B[nowB - 1];
        }

        // for (int i = 0; i < nowA; i++) System.out.print(A[i] + " ");
        // System.out.println("");
        // for (int i = 0; i < nowB; i++) System.out.print(B[i] + " ");

        int ans = 1;
        int win = 0; // OO, OX, XO
        int pre = 0;
        for (int i = 0; i < Math.max(nowA, nowB); i++) {
            if (A[i] == B[i]) win = 0;
            else if (A[i] > B[i]) win = 1;
            else win = 2;

            if (i == 0) {
                pre = win;
                continue;
            }

            if (pre != win) ans++;

            pre = win;
        }
        System.out.println(ans);
    }
}