
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M, B;
    static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M, B
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        B = Integer.parseInt(str[2]);
        ground = new int[N][M];

        int max = 0;
        int min = 500;

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(arr[j]);
                if (max < ground[i][j]) max = ground[i][j];
                if (min > ground[i][j]) min = ground[i][j];
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;

        // 모든 min-max 사이의 층에 대해 최소 구하기
        for (int i = min; i <= max; i++) {
            int block = B;
            int newTime = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (ground[j][k] > i) {
                        newTime += (2 * (ground[j][k] - i));
                        block += (ground[j][k] - i);
                    }

                    if (ground[j][k] < i) {
                        newTime += (i - ground[j][k]);
                        block -= (i - ground[j][k]);
                    }
                }
            }
            if (block < 0) break;

            if (time >= newTime) {
                time = newTime;
                height = i;
            }
        }

        System.out.println(time + " " + height);
    }
}
