import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        // Please write your code here.
        System.out.println(new N("codetree", 10).toString());
        System.out.println(new N(id, level).toString());
    }
}

class N {
    String id;
    int level;

    N(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public String toString() {
        return "user " + id + " lv " + level;
    }
}