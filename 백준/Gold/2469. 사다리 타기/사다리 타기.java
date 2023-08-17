
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine()); // 가로 줄의 수
        int targetLine = 0;
        char[][] sadari;

        char[] start = new char[K];
        char[] movement = br.readLine().toCharArray();
        sadari = new char[N][K - 1];

        for (int i = 0; i < K; i++) {
            start[i] = (char) ('A' + i);
        }

        for (int i = 0; i < N; i++) {
            sadari[i] = br.readLine().toCharArray();

            if (sadari[i][0] == '?') targetLine = i; // 어떤 줄이 ??인지 확인
        }

        for (int i = 0; i < targetLine; i++) { // targetLine 기준으로 위 사다리 이동
            for (int j = 0; j < K - 1; j++) {
                if (sadari[i][j] == '-') { // j, j + 1 연결되어 있으므로 변경
                    char tmp = start[j];
                    start[j] = start[j + 1];
                    start[j + 1] = tmp;
                }
            }
        }

        for (int i = N - 1; i > targetLine; i--) { // targetLine 기준으로 아래 사다리 이동
            for (int j = 0; j < K - 1; j++) {
                if (sadari[i][j] == '-') { // j, j + 1 연결되어 있으므로 변경
                    char tmp = movement[j];
                    movement[j] = movement[j + 1];
                    movement[j + 1] = tmp;
                }
            }
        }

        // ?? 채우기
        for (int i = 0; i < K - 1; i++) {
            if (start[i] == movement[i]) sb.append('*');
            else if (start[i] == movement[i + 1] || start[i + 1] == movement[i]) {
                sb.append('-');
                char tmp = start[i];
                start[i] = start[i + 1];
                start[i + 1] = tmp;
            } else {
                for (int j = 0; j < K - 1; j++)
                    System.out.print("x");
                System.out.println();
                return;
            }
        }
        System.out.println(sb);
    }
}
