import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>(); // (

        int sum = 0;
        int value = 1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.add('(');
                value *= 2;
            } else if (chars[i] == '[') {
                stack.add('[');
                value *= 3;
            } else if (chars[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                } else if (chars[i - 1] == '(') {
                    sum += value;
                }
                stack.pop();
                value /= 2;
            } else if (chars[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                } else if (chars[i - 1] == '[') {
                    sum += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(sum);
    }
}
