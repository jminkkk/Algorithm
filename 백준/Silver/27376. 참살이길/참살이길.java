import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.TreeMap;

public class Main {
    static long n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        TreeMap<Long, long[]> pointAndTimes = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            str = bufferedReader.readLine().split(" ");
            long point = Integer.parseInt(str[0]);
            long internal = Integer.parseInt(str[1]);
            long initTime = Integer.parseInt(str[2]);

            pointAndTimes.put(point, new long[]{internal, initTime});
        }

        long currentTime = 0;
        long currentPoint = 0;

        for (long point: pointAndTimes.keySet()) {
            long[] internalAndInitTime = pointAndTimes.get(point);

            // 1. 현재 거리까지 이동 시간
            currentTime += point - currentPoint;

            // 2. 새로운 지점에서 이동 가능한 시간까지 대기
            long intialT = internalAndInitTime[1];
            if (currentTime < intialT) {
                currentTime += (intialT - currentTime);
                currentPoint = point;
                continue;
            }

            // 3. 새로운 지점에서 신호등 바뀌기 전까지 대기
            long internalTime = currentTime - intialT;
            long internalT = internalAndInitTime[0];
            long waiting = internalTime / internalT;
            if (waiting % 2 != 0) { // 빨간 불
                currentTime += internalT * (waiting + 1) - internalTime;
            }

            currentPoint = point;
        }

        currentTime += (n - currentPoint);
        System.out.print(currentTime);
    }
}
