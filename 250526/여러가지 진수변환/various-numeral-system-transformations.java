import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        int sum = n % b;
        n /= b;

        int ten = 1;
        for (int i = 0; n >= b; i++) {
            sum += (n % b) * Math.pow(10, ten++);
            n /= b;
        }
        
        sum += (n % b) * Math.pow(10, ten);
        System.out.println(sum);
    }
}