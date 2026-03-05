import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_16953/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a, 0));
        while(!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == b) {
                System.out.println(p.y + 1);
                return;
            }
            if (p.x > b) continue;

            if ((long) p.x * 2 <= b) q.add(new Point(p.x * 2, p.y + 1));
            if ((long) p.x * 10 + 1 <= b) q.add(new Point(p.x * 10 + 1, p.y + 1));
        }

        System.out.println(-1);

        bw.flush();
        bw.close();
        br.close();
    }
}
