
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String>[] arr = new ArrayList[N];

        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
            String cur = br.readLine();

            for (int j = 0; j < cur.length(); j++) {
                arr[i].add(cur.substring(j) + cur.substring(0, j));
            }

            boolean chk = true;
            for (int j = 0; chk && j <= i - 1; j++) {
                if (arr[j].contains(cur)) {
                    chk = false;
                }
            }
            
            if (chk) {
                count++;
            }
        }
        System.out.println(count);
    }
}
