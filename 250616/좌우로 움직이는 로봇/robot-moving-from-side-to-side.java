import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a = new int[1_000_001];
        int[] b = new int[1_000_001];

        int idxA = 0;
        int idxB = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            
            for (int j = 0; j < t; j++) {
                if (i == 0 && j == 0) a[0] = d == 'L' ? -1 : 1;
                else a[idxA] = d == 'L' ? a[idxA - 1] - 1 : a[idxA - 1]  + 1;

                idxA++;
            }
        }
        
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            for (int j = 0; j < t; j++) {
                if (i == 0 && j == 0) b[0] = d == 'L' ? -1 : 1;
                else b[idxB] = d == 'L' ? b[idxB - 1] - 1 : b[idxB - 1]  + 1;

                idxB++;
            }
        }
        
        int answer = 0;
        for (int i = 1; i < Math.max(idxA, idxB); i++) {
            if (i <= Math.min(idxA, idxB) ) {
                if (a[i] == b[i] && a[i - 1] != b[i - 1]) answer++;
            } else {
                if (idxA < idxB && a[idxA - 1] == b[i] && b[i] != b[i - 1]) answer++;
                if (idxA > idxB && b[idxB - 1] == a[i] && a[i] != a[i - 1]) answer++;
            }
        }

        System.out.println(answer);
    }
}