import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] student = new int[n];
        int[] penalizedPerson = new int[m];
        boolean pernalty = false;

        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();

            student[penalizedPerson[i] - 1]++;
            if (!pernalty && student[penalizedPerson[i] - 1] == k) {
                System.out.println(penalizedPerson[i]);
                break;
            }
        }
        // Please write your code here.
    }
}