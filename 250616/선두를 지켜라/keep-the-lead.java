import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] positionA = new int[1_000_001];
        int[] positionB = new int[1_000_001];
        int[][] A = new int[n][2];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();

            for (int j = 0; j < A[i][1]; j++) {
                if (idx == 0) positionA[idx] = A[i][0];
                else positionA[idx] = positionA[idx - 1] + A[i][0];
                idx++;
            }
        }
        
        idx = 0;
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();

            for (int j = 0; j < B[i][1]; j++) {
                if (idx == 0) positionB[idx] = B[i][0];
                else positionB[idx] = positionB[idx - 1] + B[i][0];
                idx++;
            }
        }

        int answer = 0;
        boolean winA = false;
        boolean startGap = false;
        for (int i = 0; i < idx; i++) {
            if (!startGap) {
                if (positionA[i] == positionB[i]) continue;
                
                winA = positionA[i] > positionB[i];
                startGap = true;
                
                continue;
            }

            if ((winA && positionA[i] < positionB[i]) || !winA && positionA[i] > positionB[i]) {
                winA = !winA;
                answer++;
            }
        }

        System.out.println(answer);
    }
}