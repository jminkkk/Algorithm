import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (list.contains(num)) {
                int now = list.remove(0);
                while (num != now) {
                    sb.append("+").append("\n");
                    stack.add(now);
                    now = list.remove(0);
                }

                sb.append("+").append("\n");
                sb.append("-").append("\n");
            } else {
                int nowPop = stack.pop();
                if (nowPop != num) {
                    System.out.println("NO");
                    return;
                } else {
                    sb.append("-").append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
