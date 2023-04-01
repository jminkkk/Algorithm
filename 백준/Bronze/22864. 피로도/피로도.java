import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        // 입력 : N K
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int piro = 0;
        int work = 0;

        for (int i = 0; i < 24; i++) {
            if (!(piro + A > M)) { //일을 한번 더 했을 때 피로도가 M을 넘지 않는다면
                piro += A;
                work += B;
            }
            else { // 휴식
                if (piro - C <= 0) {  // 피로도가 음수가 될 경우
                    piro = 0;
                }
                else piro -= C;
            }
        }
        System.out.println(work);
    }
}