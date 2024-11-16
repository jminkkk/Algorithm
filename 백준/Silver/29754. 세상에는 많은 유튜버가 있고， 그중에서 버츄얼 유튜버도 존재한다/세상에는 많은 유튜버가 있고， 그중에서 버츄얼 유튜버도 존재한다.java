import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Main {
    static int n, m;
    static Map<String, Integer[][]> map; // [주차별][0: 주차횟수, 1: 주차시간]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int week = m / 7;

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            Integer[][] arr = map.getOrDefault(str[0], new Integer[week + 1][2]);

            int nowWeek = (Integer.parseInt(str[1]) - 1) / 7;
            arr[nowWeek][0] = arr[nowWeek][0] == null ? 1 : arr[nowWeek][0] + 1;
            int minutes = (int) Duration.between(LocalTime.parse(str[2]), LocalTime.parse(str[3])).toMinutes();
            arr[nowWeek][1] = arr[nowWeek][1] == null ? minutes : arr[nowWeek][1] + minutes;
            map.put(str[0], arr);
        }

        List<String> virtual = new ArrayList<>();
        for (String name : map.keySet()) {
            Integer[][] integers = map.get(name);
            boolean flag = false;
            for (int i = 0; i < week; i++) {
                if (integers[i][0] == null || integers[i][1] == null || !(integers[i][0] >= 5) || !(integers[i][1] >= 3600)) flag = true;
            }

            if (!flag) virtual.add(name);
        }

        if (virtual.isEmpty()) {
            System.out.println(-1);
            return;
        }

        virtual.sort(Comparator.naturalOrder());
        virtual.forEach(System.out::println);
    }
}
