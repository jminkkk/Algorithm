import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id2 = sc.next();
        int code2 = sc.nextInt();
        // Please write your code here.
        Product product = new Product("codetree", 50);
        System.out.println(product.toString());
        Product product2 = new Product(id2, code2);
        System.out.println(product2.toString());
    }
}

class Product {
    String name;
    int code;

    public Product(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String toString() {
        return "product " + String.valueOf(code) + " is " + name;
    }
}