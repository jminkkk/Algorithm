import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int cnt = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            
            if (i == 0) continue;

            if (arr[i] != arr[i - 1]) {
                max = Math.max(max, cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        System.out.println(max);
    }
}