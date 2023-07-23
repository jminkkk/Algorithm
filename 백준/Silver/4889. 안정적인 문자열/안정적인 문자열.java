import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            String str = br.readLine();
            if (str.indexOf('-') != -1) {
                break;
            }

            int num = checkNum(str);
            list.add(num);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    // 안정된 문자열 만들기 위한 최소 연산의 수
    public static Integer checkNum(String str) {
        int count = 0;
        Stack stack = new Stack<>();

        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] arr = str.toCharArray();

        for (char c : arr) {
            if (c == '{') stack.add('{');
            else {
                if (stack.empty()) {
                    count++;
                    stack.add('{');
                }
                else stack.pop();
            }
        }
        return count + stack.size()/2;
    }
}