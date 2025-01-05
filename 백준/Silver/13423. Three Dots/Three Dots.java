import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            m = Integer.parseInt(str[0]);

            int[] arr = new int[m];
            str = br.readLine().split(" ");
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(str[j]);
                set.add(arr[j]);
            }

            Arrays.sort(arr);
            int count = 0;
            for (int j = 0; j < set.size() - 1; j++) {
                for (int k = j + 1; k < set.size(); k++) {
                    int gap = arr[k] - arr[j];
                    int next = gap + arr[k];

                    if (set.contains(next)) count++;
                }
            }

            System.out.println(count);
        }

    }
}
