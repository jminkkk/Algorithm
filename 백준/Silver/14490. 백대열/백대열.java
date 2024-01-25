import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(":");
        int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
        int max = 1;
        List<Integer> aList = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                aList.add(i);
                aList.add(a / i);
            }
        }

        for (int i = 1; i < aList.size(); i++) {
            if (b % aList.get(i) == 0) {
                max = Math.max(max, aList.get(i));
            }
        }

        System.out.println(a / max + ":" + b / max);
    }
}
