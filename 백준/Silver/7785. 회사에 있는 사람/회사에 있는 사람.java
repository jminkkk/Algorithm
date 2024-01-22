
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        // Queue<String> q = new LinkedList<>();
        Set<String> list = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            if (log[1].equals("leave")) {
                list.remove(log[0]);
            } else {
                list.add(log[0]);
            }
        }
        list.stream()
                .sorted(Collections.reverseOrder())
//        q.stream().sorted(Collections.reverseOrder())
                .forEach(s -> sb.append(s + "\n"));
        System.out.print(sb);
    }
}
