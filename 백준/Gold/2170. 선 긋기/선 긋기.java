import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            points.add(new Point(x, y));
        }

        points.sort((point1, point2) -> {
            if (point1.x ==  point2.x) {
                return point1.y - point2.y;
            }
            return point1.x - point2.x;
        });

        Point pre = points.get(0);
        int maxX = pre.x;
        int maxY = pre.y;
        long sum = Math.abs(maxY - maxX);

        for (int i = 1; i < points.size(); i++) {
            Point point = points.get(i);

            if (point.x >= maxY) {
                sum += Math.abs(point.y - point.x);
            } else if (point.y > maxY) {
                sum += Math.abs(point.y - maxY);
            }

            maxX = Math.min(point.x, maxX);
            maxY = Math.max(point.y, maxY);
        }

        System.out.println(sum);
    }

}
