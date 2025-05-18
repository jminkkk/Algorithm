import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int cnt = 0;
        int[] digit = new int[20];
        while (true) {
            if (n < 2) {
                digit[cnt] = n;
                break;
            }

            digit[cnt++] = n % 2;
            n /= 2;
        }

        for (int i = cnt; i >= 0; i--) {
            System.out.print(digit[i]);
        }
    }
}