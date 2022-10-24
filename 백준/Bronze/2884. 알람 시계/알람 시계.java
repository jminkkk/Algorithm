import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.close();

        if((m>45)) System.out.print(h + " " +(m-45)); // m이 45보다 클 때 
        else if ((m == 45)) System.out.println(h + " " + "0"); // m이 45
        else if ((m<45) && (h==0)) System.out.println(23 + " " + (m+15));
        else System.out.println((h-1) + " " + (m+15));
    }
}
