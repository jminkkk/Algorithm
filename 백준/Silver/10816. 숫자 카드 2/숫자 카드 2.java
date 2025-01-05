import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);

        str = br.readLine().split(" ");
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        str = br.readLine().split(" ");
        m = Integer.parseInt(str[0]);

        StringBuilder sb = new StringBuilder();
        str = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(str[i]);
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
