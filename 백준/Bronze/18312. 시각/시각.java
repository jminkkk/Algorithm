import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        // 입력 : N K
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 0; i <= N * 3600 + 59 * 60 + 59; i++) { //3644초 -> / 3600 1시간 0분 44초 044
            int hourTen = (i / 3600) / 10;
            int hourOne = (i / 3600) % 10;
            int minuteTen = ((i % 3600) / 60) / 10;
            int minuteOne = ((i % 3600) / 60) % 10;
            int secondTen = (((i % 3600) % 60) / 10);
            int secondOne = (((i % 3600) % 60) % 10);
            if (hourTen == K || hourOne == K || minuteTen == K || minuteOne == K || secondTen == K || secondOne == K) {
                count++;
            }
        }

        System.out.println(count);
    }
}