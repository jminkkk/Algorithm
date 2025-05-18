import java.util.Scanner;
public class Main {
    static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] yoil = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    private static int get(int m, int d) {
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
        
        int gap = get(m2, d2) - get(m1, d1);

        if (gap == 0) {
            System.out.println(yoil[0]);
        } else if (gap >0) {
            System.out.println(yoil[gap % 7]);
        } else {
            System.out.println(yoil[7 - (Math.abs(gap) % 7)]);
        }
    }
}