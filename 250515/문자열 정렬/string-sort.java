import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        System.out.println(new String(arr));
    }
}