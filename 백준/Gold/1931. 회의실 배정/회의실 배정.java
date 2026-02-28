
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_11399/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int cnt = 1;
        int[] pre = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int[] cur = arr[i];
            if (pre[0] >= cur[1]) {
                cnt++;
                pre = cur;
                continue;
            }

            if (pre[0] <= cur[0]) {
                pre = cur;
            }
        }

        System.out.println(cnt);

        bw.flush();
        bw.close();
        br.close();
    }
}
//now = (x, y)
//for (new : pq) {
//	if (now.x >= new.y) {
//		cnt++;
//		now = new;
//	} else {
//		if (now.x <= new.x) now = new;
//	}
//}
