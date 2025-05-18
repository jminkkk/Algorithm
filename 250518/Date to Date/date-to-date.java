import java.util.Scanner;
public class Main {
    static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static int find(int m, int d) {
        int sum = 0;

        for (int i = 1; i < m; i++) {
            sum += days[i];
        }

        sum += d;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        

        System.out.println(find(m2, d2) - find(m1, d1) + 1);
    }
}