import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[][] node;

    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        // 방향 없는 그래프가 주어졌을 때,
        // 연결 요소 (Connected Component)의 개수를 구하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);

        answer = 0;

        node = new int[N + 1][N + 1];

        // 정점의 개수 N, 간선의 개수 M
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            node[a][b] = node[b][a] = 1;
        }

        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void DFS(int start) {
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (node[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }
}
