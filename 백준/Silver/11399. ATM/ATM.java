
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_11399/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n =  Integer.parseInt(input[0]);

        int[] arr = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int[] sum = new int[n];
        sum[0] = arr[0];
        int answer = sum[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
            answer += sum[i];
        }

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}
