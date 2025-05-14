import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        
        System.out.println(get(n - 1));
    }

    private static int get(int idx) {
        if (idx == 0) return arr[idx];

        int pre = get(idx - 1);
        for (int i = 2; i <= arr[idx] * pre; i++) {
            if (i % arr[idx] == 0 && i % pre == 0) return i;
        }

        return 0;
    }
}