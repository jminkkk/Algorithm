
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java//input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(str[i]);

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        long answer = Long.MAX_VALUE;

        int answerLeft = 0;
        int answerRight = 0;

        while(left < right) {
            long gap = Math.abs((long) arr[right] + arr[left]);
            if (gap < answer) {
                answer = Math.abs(gap);
                answerLeft = arr[left];
                answerRight = arr[right];
            }

            if (Math.abs(arr[right]) > Math.abs(arr[left])) {
                right--;
            } else if (Math.abs(arr[right]) < Math.abs(arr[left])) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(answerLeft + " " + answerRight);

        bw.flush();
        bw.close();
        br.close();
    }
}
