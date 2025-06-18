import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            int idx = 0;

            if (direction == 'W') idx = 3;
            else if (direction == 'S') idx = 2;
            else if (direction == 'N') idx = 0;
            else idx = 1;

            x += (dx[idx] * distance);
            y += (dy[idx] * distance);
        }
        
        System.out.println(x + " " + y);
    }
}