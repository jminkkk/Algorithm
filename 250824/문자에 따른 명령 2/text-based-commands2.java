import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();

        int x = 0, y = 0;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'L') idx = (idx - 1 + 4) % 4;
            else if (arr[i] == 'R') idx = (idx + 1) % 4;
            else if (arr[i] == 'F') {
                x += dx[idx];
                y += dy[idx];
            }
        }
        System.out.println(y + " " + x);
    }
}