
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_16953/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int cnt = 1;

        while (a < b) {
            if (b % 2 == 0) {
                b /= 2;
            } else if ((b - 1) % 10 == 0) {
                b = (b - 1) / 10;
            } else {
                System.out.println(-1);
                return;
            }
            cnt++;
        } // 2 172

        if (a == b) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
