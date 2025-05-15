import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        // Please write your code here.
        String[] arr = Arrays.stream(words)
            .filter(word -> word.startsWith(t))
            .sorted()
            .mapToString(i -> i)
            .toArray();
        System.out.println(arr[k - 1]);
    }
}