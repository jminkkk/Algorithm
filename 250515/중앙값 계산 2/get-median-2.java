import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Please write your code here.
        for (int i = 0; i < n; i += 2) {
            Arrays.sort(arr, 0, i + 1);
            System.out.print(arr[i / 2] + " ");
        } // 1 2 3 4 5 6 7
    }
}
