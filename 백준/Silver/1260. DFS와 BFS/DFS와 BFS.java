import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static int N, M, V;

    static int[][] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]); // 정점의 개수 N
        M = Integer.parseInt(str[1]); // 간선의 개수 M
        V = Integer.parseInt(str[2]); //  시작 번호 V

        visited = new boolean[N + 1];
        node = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] nodeStr = br.readLine().split(" ");
            int a = Integer.parseInt(nodeStr[0]);
            int b = Integer.parseInt(nodeStr[1]);

            node[a][b] = node[b][a] = 1;
        }

        // DFS - 재귀
        DFS(V); // 방문할 인덱스, 이어진 노드들(정렬됨), 이동할 인덱스가 몇번째로 작은 인덱스
        Arrays.fill(visited, false); // visited 배열 초기화
        sb.append("\n");
        // BFS - 스택
        BFS(V);

        System.out.println(sb);
    }

    public static void DFS(int index) {
        visited[index] = true; // 방문 처리
        sb.append(index + " ");

        for (int i = 0; i <= N; i++) {
            if (node[index][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            index = queue.poll();
            sb.append(index + " ");

            for (int i = 0; i <= N; i++) {
                if (node[index][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
