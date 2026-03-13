
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_13913/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int[] position = new int[100_001]; // 각 위치까지 걸리는 최단 시간
        int[] parent = new int[100_001]; // 각 위치까지 걸리는 최단 시간
        boolean[] visited = new boolean[100_001];
        Queue<Integer> q = new LinkedList<>();
        position[n] = 0;
        visited[n] = true;
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                break;
            }

            int[] nexts = new int[]{now + 1, now - 1, now * 2};
            for (int next: nexts) {
                if (next < 0 || next > 100_000) continue;
                if (visited[next]) continue;

                visited[next] = true;
                parent[next] = now;
                position[next] = position[now] + 1;
                q.add(next);
            }
        }

        System.out.println(position[k]);

        int now = k;
        List<Integer> nums = new ArrayList<>();
        while (now != n) {
            nums.add(now);
            now = parent[now];
        }
        nums.add(n);

        for (int i = nums.size() - 1; i >= 0; i--) {
            System.out.print(nums.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
