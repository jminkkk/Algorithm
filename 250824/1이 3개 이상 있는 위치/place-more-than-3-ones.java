import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int cnt = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int oneCnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dy[i];
                    int nc = c + dx[i];
                    if (nr < 0 || nc < 0 || nc >= n || nr >= n) continue;
                    
                    if (arr[nr][nc] == 1) oneCnt++;
                }

                if (oneCnt >= 3) cnt++;
            }
        }
        System.out.println(cnt);
    }
}