
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') {
                for (int j = i; j < S.length(); j++) {
                    sb.append(S.charAt(j));
                    i++;

                    if (S.charAt(j) == '>') {
                        break;
                    }
                }
                i --;
            }
            else if (S.charAt(i) == ' ') {
                sb.append(" ");
            } else {
                int index = i;

                while (index < S.length() && S.charAt(index) != ' ' && S.charAt(index) != '<') {
                    stack.push(S.charAt(index));
                    index++;
                }

                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                i = index - 1;
            }
        }
        System.out.println(sb.toString());
    }
}
