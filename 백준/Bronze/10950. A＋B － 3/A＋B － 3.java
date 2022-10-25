import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arraya = new int[n];
        int[] arrayb = new int[n];

        for(int i=0 ; i<n ;i++){
            arraya[i] = scanner.nextInt();
            arrayb[i] = scanner.nextInt();
        }
        scanner.close();

        for(int i =0 ; i<n ;i++){
            System.out.println(arraya[i]+arrayb[i]);
        }
    }
}
