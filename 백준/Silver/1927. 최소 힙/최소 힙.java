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

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String v = br.readLine();
            if (v.equals("0")) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pq.poll());
                continue;
            }
            pq.add(Integer.parseInt(v));
        }

    }
}
