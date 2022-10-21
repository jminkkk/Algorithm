import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int king = scanner.nextInt();
        int queen = scanner.nextInt();
        int look = scanner.nextInt();
        int bishop = scanner.nextInt();
        int night = scanner.nextInt();
        int phone = scanner.nextInt();

        System.out.print(1-king +" ");
        System.out.print(1-queen + " ");
        System.out.print(2-look + " ");
        System.out.print(2-bishop + " ");
        System.out.print(2-night + " ");
        System.out.print(8-phone+ " ");
    }
}