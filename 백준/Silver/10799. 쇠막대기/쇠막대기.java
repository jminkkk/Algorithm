import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        Deque<Integer> deque = new ArrayDeque<>();
        int sum = 0;

        String pre = "";
        for (String s : str) {
            if (s.equals("(")) {
                deque.addLast(0);
            } else {
                if (pre.equals("(")) {
                    deque.removeLast();
                    sum += deque.size();
                } else if (!deque.isEmpty()) {
                    int cnt = deque.removeLast();
                    sum += cnt + 1;
                }
            }
            pre = s;
        }

        System.out.println(sum);
    }
}
