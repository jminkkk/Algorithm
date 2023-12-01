import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                map.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            System.out.println(check(map));
        }
    }

    public static int check(Map<Integer, Integer> map) {
        int size = map.size();
        // 선발되지 못하는 인원
        int count = 0;
        int min = map.get(1);

        for (int i = 2; i <= size; i++) {
            if (map.get(i) > min) {
                count++;
            } else {
                min = map.get(i);
            }
        }

        return size - count;
    }
}
