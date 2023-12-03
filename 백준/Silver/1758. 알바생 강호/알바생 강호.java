import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort((o1, o2) -> o2 - o1);

        long sum = 0;

        for (int i = 1; i <= N;  i++) {
            int tip = Math.max(list.get(i - 1) - i + 1, 0);
            sum += tip;

        }

        System.out.println(sum);
    }
}
