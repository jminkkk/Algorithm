import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);

        str = br.readLine().split(" ");
        int t = Integer.parseInt(str[0]);

        List<Integer> cnts = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        str = br.readLine().split(" ");
        for (int i = 0; i < 2 * n; i++) {
            deque.addLast(Integer.parseInt(str[i]));
        }

        StringBuilder sb = new StringBuilder();
        str = br.readLine().split(" ");
        for (int i = 0; i < t; i++) {
            int now = Integer.parseInt(str[i]) % (2 * n);
            if (now == 0) now = (2 * n);

            for (int j = 0; j < now - 1; j++) {
                deque.addLast(deque.removeFirst());
            }

            sb.append(deque.getFirst()).append(" ");
        }

        System.out.println(sb);
    }
}
//  2 1 6 5 4 3

// 4
// 2
// (f) 4 3 3 1 2 1 2 4 (l)
// 3 12

