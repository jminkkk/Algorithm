import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(get(n));
    }

    private static int get(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return get((int) Math.floor((double) n / 3)) + get(n - 1);
    }
}