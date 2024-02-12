
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int head = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int minX = 0;
            int minY = 0;
            int maxX = 0;
            int maxY = 0;

            int[] curr = {0, 0};

            String course = br.readLine();
            char[] path = course.toCharArray();
            for (char move: path) {
                move(move, curr);
                if (curr[0] < minX) minX = curr[0];
                else if (curr[0] > maxX) maxX = curr[0];
                else if (curr[1] < minY) minY = curr[1];
                else if (curr[1] > maxY) maxY = curr[1];
            }
            int width = maxX - minX;
            int height = maxY - minY;
            System.out.println(width * height);
        }
    }

    public static void move(char move, int[] curr) {
        if (move == 'L') {
            if (head == 0) head = 3;
            else head--;
        } else if (move == 'R') {
            if (head == 3) head = 0;
            else head++;
        } else if(move == 'F') {
            if (head == 0) {
                curr[1]++;
            } else if (head == 1) {
                curr[0]++;
            } else if (head == 2) {
                curr[1]--;
            } else if (head == 3) {
                curr[0]--;
            }
        } else {
            if (head == 0) {
                curr[1]--;
            } else if (head == 1) {
                curr[0]--;
            } else if (head == 2) {
                curr[1]++;
            } else if (head == 3) {
                curr[0]++;
            }
        }
    }
}