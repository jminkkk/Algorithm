import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int hour = ((b+c)/60 + a) %24;
        int minute = (b+c) % 60;
        scanner.close();

        System.out.println(hour + " " + minute);

    }
}
