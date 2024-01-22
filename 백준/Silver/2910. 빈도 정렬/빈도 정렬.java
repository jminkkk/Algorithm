
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new LinkedHashMap<>();

        Integer N = Integer.parseInt(br.readLine().split(" ")[0]);
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            map.merge(Integer.parseInt(str[i]), 1, Integer::sum);
        }

        map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .forEach(entry -> {
                for (int i = 0; i < entry.getValue(); i++) {
                    System.out.print(entry.getKey() + " ");
                }
            });
    }
}
