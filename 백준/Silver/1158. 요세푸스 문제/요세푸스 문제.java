import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        StringBuilder answer = new StringBuilder("<");
        int i = 0;
        while (list.size() > 1) {
            i = (i + k -1) % list.size();
            int now = list.remove(i);
            answer.append(now).append(", ");
        }

        answer.append(list.get(0)).append(">");
        System.out.println(answer);
    }
}
