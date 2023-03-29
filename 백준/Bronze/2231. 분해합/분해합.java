import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        //분해합
        // 어떤 M의 분해합이 N 인 경우
        // M은 N의 생성자이다

        // N이 주어졌을 때 N의 가장 작은 생성자를 구하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        System.out.println(bunhaeHap(N));
    }

    private static int bunhaeHap(Integer n) {
        for (int i = 0; i < n; i++) {
            String[] str = String.valueOf(i).split("");
            int sum = i;

            for (int j = 0; j < str.length; j++) {
                sum += Integer.parseInt(str[j]);
            }

            if (sum == n) return i;
        }
        return 0;
    }
}