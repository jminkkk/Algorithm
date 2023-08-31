
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        List<Integer> countAndList = new ArrayList<>();
        int count = 0;

        for (int i = N; i >= N / 2; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(N);

            int tmp = N;
            int tmp2 = i;

            while (true) {
                if (tmp < 0) break;

                int tmp3 = tmp;
                if (tmp2 >= 0) list.add(tmp2);

                tmp = tmp2;
                tmp2 = tmp3 - tmp;
            }

            if (count < list.size()) {
                count = list.size();
                countAndList = list;
            }
        }

        System.out.println(count);
        countAndList.forEach(i -> System.out.print(i + " "));
    }
}