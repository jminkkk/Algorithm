import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        while (deque.size() != 1) {
            deque.removeFirst();
            int card = deque.removeFirst();
            deque.addLast(card);
        }

        System.out.println(deque.remove());
    }
}
