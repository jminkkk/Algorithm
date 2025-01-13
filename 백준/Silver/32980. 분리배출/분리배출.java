import java.io.BufferedReader;
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

        int[] cnt = new int[7];
        long sum = 0;

        for (int i = 0; i <  n; i++) {
            String trash = br.readLine();
            String substring = trash.substring(0, 1);
            String newTrash = trash.replaceAll(substring, "");
            if (newTrash.isEmpty()) {
                cnt[index(substring)] += trash.length();
            } else {
                cnt[6] += trash.length();
            }
        }

        str = br.readLine().split(" ");
        int common = Integer.parseInt(br.readLine());
        for (int i = 0; i < 6; i++) {
            sum += (long) cnt[i] * Math.min(Integer.parseInt(str[i]), common);
        }

        sum += (long) common * cnt[6];
        System.out.println(sum);
    }

    private static int index(String str) {
         if ("P".equals(str)) return 0;
         if ("C".equals(str)) return 1;
         if ("V".equals(str)) return 2;
         if ("S".equals(str)) return 3;
         if ("G".equals(str)) return 4;
         if ("F".equals(str)) return 5;
         return 6;
    }
}
