import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] white = new int[200_001];
        int[] black = new int[200_001];
        int[] last = new int[200_001];

        int now = 100_000;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            for (int j = 0; j < x; j++){
                if (d == 'R') {
                    if (j != 0) now++;
                    last[now] = 'R';
                    white[now]++;
                } else {
                    if (j != 0) --now;
                    black[now]++;
                    last[now] = 'L';
                }
            }
        }
        
        int wCnt = 0;
        int bCnt = 0;
        int gCnt = 0;
        for (int i = 0; i < 200_000; i++) {
            if (white[i] >= 2 && black[i] >= 2) {
                gCnt++;
            } else if (white[i] != 0 || black[i] != 0 ) {
                if (last[i] == 'R') {
                    bCnt++;
                } else {
                    wCnt++;
                }
            }
        }

        System.out.println(wCnt + " " + bCnt + " " + gCnt);
    }
}