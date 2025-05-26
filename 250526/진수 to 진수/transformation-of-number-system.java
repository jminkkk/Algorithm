import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        // Please write your code here.

        int sum = 0;
        int cnt = 0;
        while (N >= 1) {
            sum += Math.pow(A, cnt++) * (N % 10);
            N /= 10;
        }

        int[] digit = new int[20];
        cnt = 0;
        while (sum >= 1) {
            digit[cnt++] = sum % B;
            sum /= B;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = cnt - 1; i >= 0; i--) {
            sb.append(digit[i]);
        }

        System.out.println(sb.toString());
    }
}