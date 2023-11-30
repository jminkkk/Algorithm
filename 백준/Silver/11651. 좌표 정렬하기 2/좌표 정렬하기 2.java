import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Point p = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            list.add(p);
        }

        list.sort(Comparator.naturalOrder());
        list.forEach(p -> System.out.println(p.x + " " + p.y));
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point p) {
        if (this.y == p.y) {
            return this.x - p.x;
        }
        return this.y - p.y;
    }
}