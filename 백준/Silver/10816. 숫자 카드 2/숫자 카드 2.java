
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_10816/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        arr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(arr[i]);
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
