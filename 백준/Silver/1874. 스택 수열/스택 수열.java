import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int start = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (!stack.contains(num)) {
                while (start != num) {
                    sb.append("+").append("\n");
                    stack.add(start++);
                }
                sb.append("+").append("\n");
                sb.append("-").append("\n");
                start++;
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
