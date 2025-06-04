import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int now = 1000;
        int[] arr = new int[2001];
        char pre = '0';
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            
            if (dir == 'L') {
                for (int j = 0; j < x; j++) {
                    arr[now++]++;
                }
            } else {
                for (int j = 0; j < x; j++) {
                    arr[--now]++;
                }
            }
            pre = dir;
        }
        
        int answer = 0;
        for (int i = 0; i < 2001; i++) {
            if (arr[i] >= 2) answer++;
        }
        System.out.println(answer);
    }
}