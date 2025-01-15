import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        Stack<String> back = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            stack.push(str[i]);
        }

        str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            if (str[0].equals("L")) {
                if (stack.isEmpty()) continue;
                back.push(stack.pop());
            } else if (str[0].equals("D")) {
                if (back.isEmpty()) continue;
                stack.push(back.pop());
            } else if (str[0].equals("B")) {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else { // 1 2 3
                stack.push(str[1]);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (String s: stack) sb.append(s);
        System.out.print(sb);

        sb = new StringBuilder();
        for (String s: back) sb.append(s);
        System.out.println(sb.reverse());
    }
}
