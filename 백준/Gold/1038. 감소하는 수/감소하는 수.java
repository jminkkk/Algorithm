
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
        } else if (N > 1022) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++) {
                check((long) i, 1);
            }

            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }

    public static void check(Long number, int depth) {
        if (depth > 10) {
            return;
        }

        list.add(number);
        for (int i = 0; i < number % 10; i++) {
            check(number * 10 + i, depth + 1);
        }
    }
}
