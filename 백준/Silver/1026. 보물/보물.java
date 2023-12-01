import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            aList.add(Integer.parseInt(a[i]));
            bList.add(Integer.parseInt(b[i]));
        }

        aList.sort(Comparator.naturalOrder());
        bList.sort(Comparator.naturalOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += aList.get(i) * bList.get(N - i - 1);
        }

        System.out.println(sum);
    }
}