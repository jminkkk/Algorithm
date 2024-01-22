
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (String num : str) {
            map.merge(Integer.parseInt(num), 1, Integer::sum);
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
