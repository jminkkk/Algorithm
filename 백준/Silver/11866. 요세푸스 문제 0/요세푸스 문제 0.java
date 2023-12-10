
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String[] nums = new String[N];
        List<Integer> indexs = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            indexs.add(i);
        }

        int index = K - 1;

        for (int i = 0; i < N; i++) {
            if (indexs.size() == 0) {
                break;
            }

            if (index >= indexs.size()) {
                index %= indexs.size();
            }

            nums[i] = indexs.remove(index).toString();
            index += K - 1;
        }

        System.out.println("<" + String.join(", ", nums) + ">");
    }
}
