import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1260/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        int V = Integer.parseInt(first[2]);

        // 1. 연결 상태 표현하기 O(M)
        boolean[][] connected = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] second = br.readLine().split(" ");
            int a = Integer.parseInt(second[0]);
            int b = Integer.parseInt(second[1]);

            connected[a][b] = true;
            connected[b][a] = true;
        }

        List<Integer> dfs = dfs(V, connected);
        List<Integer> bfs = bfs(V, connected);

        String dfsStr = dfs.stream().map(Object::toString).collect(Collectors.joining(" "));
        String bfsStr = bfs.stream().map(Object::toString).collect(Collectors.joining(" "));

        bw.write(dfsStr + "\n");
        bw.write(bfsStr + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public List<Integer> dfs(int cur, boolean[][] connected) {
        List<Integer> path =  new ArrayList<>();
        boolean[] visited = new boolean[connected.length];

        recursion(cur,  connected, visited, path);

        return path;
    }

    public void recursion(int cur, boolean[][] connected, boolean[] visited, List<Integer> path) {
        visited[cur] = true;
        path.add(cur);

        for (int i =0; i < connected.length; i++) {
            if (i == cur) continue;
            if (visited[i]) continue;
            if (!connected[cur][i]) continue;

            recursion(i, connected, visited, path);
        }
    }

    public List<Integer> bfs(int cur, boolean[][] connected) {
        List<Integer> path =  new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[connected.length + 1];

        queue.offer(cur);
        visited[cur] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            path.add(now);

            for (int i =0; i < connected.length; i++) {
                if (i == now) continue;
                if (visited[i]) continue;
                if (!connected[now][i]) continue;

                visited[i] = true;
                queue.offer(i);
            }
        }

        return path;
    }
}

