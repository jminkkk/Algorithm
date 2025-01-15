import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);

        Set<Integer> set = new HashSet<>();
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(str[i]));
        }

        int count  = 0;
        str = br.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        for (int i : set) {
            if (set.contains(x - i)) count++;
        }

        System.out.println(count / 2);
    }
}
