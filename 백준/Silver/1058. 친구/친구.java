import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
    static int n;
    static Map<Integer, Set<Integer>> allFriends;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        allFriends = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] str = bufferedReader.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (str[j].equals("Y")) {
                    Set<Integer> fs = allFriends.getOrDefault(i, new HashSet<>());
                    fs.add(j);
                    allFriends.put(i, fs);

                    Set<Integer> fs2 = allFriends.getOrDefault(j, new HashSet<>());
                    fs2.add(i);
                    allFriends.put(j, fs2);
                }
            }
        }

        if (allFriends.isEmpty()) {
            System.out.println(0);
            return;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (allFriends.containsKey(i)) {
                max = Math.max(max, bfs(i));
            }
        }

        System.out.println(max);
    }

    private static int bfs(int num) {
        Set<Integer> friends = allFriends.get(num);
        boolean[] visited = new boolean[n];
        visited[num] = true;

        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        friends.forEach(i -> {
            visited[i] = true;
            queue.add(new Node(i, 0));
        });

        while (!queue.isEmpty()) {
            Node now = queue.remove();
            count++;

            friends = allFriends.get(now.num);
            friends.stream()
                    .filter(i -> !visited[i] && now.depth < 1)
                    .forEach(i -> {
                        queue.add(new Node(i, now.depth + 1));
                        visited[i] = true;
                    });
        }

        return count;
    }

}
class Node {
    int num;
    int depth;

    public Node(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}
