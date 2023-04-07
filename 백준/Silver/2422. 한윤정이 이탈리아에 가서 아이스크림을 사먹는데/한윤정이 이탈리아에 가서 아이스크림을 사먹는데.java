import java.io.*;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Integer N = Integer.parseInt(st.nextToken()); // 아이스크림 종류의 수
        Integer M = Integer.parseInt(st.nextToken()); // 섞어먹으면 안 되는 조합의 개수
        Integer count = 0;

        boolean[][] no = new boolean[N][N];

        for (int k = 0; k < M; k++) { // 섞어먹으면 안되는 조합 체크
            String[] str = br.readLine().split(" ");
            Integer a = Integer.parseInt(str[0]);
            Integer b = Integer.parseInt(str[1]);

            no[a - 1][b - 1] = true;
            no[b - 1][a - 1] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N ;j++) {
                for (int k = j + 1; k < N; k++) {
                    if(!no[i][j] && !no[j][k] && !no[i][k]) count++;
                }
            }
        }
        // 가능한 방법이 몇 가지
        System.out.println(count);
    }
}
