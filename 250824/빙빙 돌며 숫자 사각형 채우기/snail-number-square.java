import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int dir = 0;

        int row = 0, col = 0;
        int arr[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];

        int cnt = 1;
        arr[0][0] = cnt;
        visited[0][0] = true;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (r == 0 && c == 0) continue;
                
                int nr = row + dx[dir];
                int nc = col + dy[dir];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) dir = (dir + 1) % 4;

                row += dx[dir];
                col += dy[dir];

                arr[row][col] = ++cnt;
                visited[row][col] = true;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println("");
        } 
   }
}