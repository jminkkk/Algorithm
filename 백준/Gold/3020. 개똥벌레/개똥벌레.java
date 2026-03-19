
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java//input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int h = Integer.parseInt(str[1]);

        int[] arr = new int[n];
        int[] cntBottomUp = new int[h + 1]; // 높이가 i인 석순의 갯수
        int[] cntTopDown = new int[h + 1];// 높이가 i인 종유석의 갯수
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                cntBottomUp[arr[i]]++;
            } else {
                cntTopDown[arr[i]]++;
            }
        }

        int[] sumBottomUp = new int[h + 1]; // 높이가 i인 석순의 갯수
        int[] sumTopDown = new int[h + 1];// 높이가 i인 종유석의 갯수

        sumBottomUp[h] = cntBottomUp[h];
        sumTopDown[h] = cntTopDown[h];
        for (int i = h - 1; i >= 1; i--) {
            sumBottomUp[i] = sumBottomUp[i + 1] + cntBottomUp[i];
            sumTopDown[i] = sumTopDown[i + 1] + cntTopDown[i];
        }

        int[] sum = new int[h + 1];
        for (int i = 1; i <= h; i++) {
            sum[i] = sumBottomUp[i] + sumTopDown[h - i + 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            if (sum[i] < min) {
                min = sum[i];
                cnt = 1;
            } else if (sum[i] == min ) cnt++;
        }

        System.out.println(min + " " + cnt);
        bw.flush();
        bw.close();
        br.close();
    }
}

