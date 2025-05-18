import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        int start = 1440 * 11 + 60 * 11 + 11;
        int end = 1440 * A + 60 * B + C;

        int answer = end - start < 0 ? -1 : end - start;

        System.out.println(answer);
    }
}