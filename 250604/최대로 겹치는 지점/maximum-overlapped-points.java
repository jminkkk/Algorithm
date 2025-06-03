import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        
        int[] arr = new int[100];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt() - 1;
            end[i] = sc.nextInt() - 1;
            for (int j = start[i]; j <= end[i]; j++) {
                arr[j]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 100; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}