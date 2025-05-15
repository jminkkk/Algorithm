import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        // Please write your code here.
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String nWord1 = new String(arr1) ;
        String nWord2 = new String(arr2) ;
        if (nWord1.equals(nWord2)) System.out.println("Yes");
        else System.out.println("No");
    }
}