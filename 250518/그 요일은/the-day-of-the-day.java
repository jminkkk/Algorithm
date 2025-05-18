import java.util.Scanner;

public class Main {
    static int[] days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    static String[] yoil = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    
    private static int find(int m, int d) {
        int sum = 0;
        for (int i = 1; i < m; i++) {
            sum += days[i]; 
        }

        sum += d;
        return sum;
    }

    private static int idx(String target) {
        for (int i = 0; i < 6; i++) {
            if (target.equals(yoil[i])) return i;
        }

        return 6;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.

        int diff = find(m2, d2) - find(m1, d1);
        int index = idx(A);

        int answer = diff / 7;

        if (diff % 7 >= index) answer++;
        System.out.println(answer);
    }
}