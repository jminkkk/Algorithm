import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        char[] arr = binary.toCharArray();
        int sum = 0;
        int cnt = arr.length - 1;
        
        for (int i = cnt; i >= 0; i--) {
            int digit = arr[i] == '1' ? 1 : 0;
            sum += Math.pow(2, cnt - i) * digit;
        }

        System.out.println(sum);
    }
}