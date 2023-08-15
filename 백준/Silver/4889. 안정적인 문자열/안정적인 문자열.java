
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int index = 1;
        int count;

        while (true) {
            if (str.charAt(0) == '-') break;
            count = 0;

            Queue<Character> queue = new LinkedList();

            for (Character c : str.toCharArray()) {
                if (c == '{') {
                    queue.add(c);
                } else {
                    if (queue.isEmpty()) {
                        count++;
                        queue.add(c);
                    } else queue.remove();
                }
            }

            if (!queue.isEmpty()) count += queue.size() / 2;
            sb.append(index + ". " + count + "\n");

            str = br.readLine();
            index++;
        }

        System.out.println(sb.toString());
    }
}
