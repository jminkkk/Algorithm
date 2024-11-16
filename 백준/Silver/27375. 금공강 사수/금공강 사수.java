import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int n, k;
    static List<int[]> classes;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        classes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            int w = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);
            int e = Integer.parseInt(str[2]);
            if (w != 5) { // Exclude classes on Friday
                classes.add(new int[]{w, s, e});
            }
        }

        count = 0;
        dfs(0, 0, new boolean[5][11]);
        System.out.println(count);
    }

    public static void dfs(int index, int credits, boolean[][] schedule) {
        if (credits == k) {
            count++;
            return;
        }
        if (index == classes.size() || credits > k) {
            return;
        }

        for (int i = index; i < classes.size(); i++) {
            int w = classes.get(i)[0];
            int s = classes.get(i)[1];
            int e = classes.get(i)[2];
            boolean conflict = false;

            for (int j = s; j <= e; j++) {
                if (schedule[w][j]) {
                    conflict = true;
                    break;
                }
            }

            if (!conflict) {
                for (int j = s; j <= e; j++) {
                    schedule[w][j] = true;
                }
                dfs(i + 1, credits + (e - s + 1), schedule);
                for (int j = s; j <= e; j++) {
                    schedule[w][j] = false;
                }
            }
        }
    }
}