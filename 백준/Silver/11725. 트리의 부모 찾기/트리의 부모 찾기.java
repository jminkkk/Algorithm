
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);

            tree.get(first).add(second);
            tree.get(second).add(first);
        }

        dfs(1);
        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int index) {
        visited[index] = true;
        List<Integer> list = tree.get(index);

        for (int i = 0; i < list.size(); i++) {
            int next = list.get(i);
            if (!visited[next]) {
                parent[next] = index;
                dfs(next);
            }
        }
    }
}
