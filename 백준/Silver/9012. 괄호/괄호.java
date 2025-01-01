import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            boolean yes = true;
            for (String now : str) {
                if (now.equals("(")) stack.add("(");
                else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        yes = false;
                    }
                }
            }

            if (stack.isEmpty() && yes) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }
}
