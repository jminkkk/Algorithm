import java.util.*;
import java.io.*;

class Main {

    static List<Integer> list;
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(new boolean[9], 0, 0, new ArrayList<>());
        Collections.sort(list, (a, b) -> arr[a] - arr[b]);

        list.forEach(i -> System.out.println(arr[i]));
    }

    private static void dfs(boolean[] visited, int cnt, int sum, List<Integer> nums) {
        if (cnt > 7) {
            return;
        }
        if (cnt == 7 && sum == 100) {
            list = nums;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            List<Integer> newNums = new ArrayList<>(nums);
            newNums.add(i);
            dfs(visited, cnt + 1, sum + arr[i], newNums);
            visited[i] = false;
        }
    }
}