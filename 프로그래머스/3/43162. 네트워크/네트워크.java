import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        boolean[] done = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || computers[i][j] == 0 || visited[i][j]) {
                    visited[i][j] = true;
                    visited[j][i] = true;
                    continue;
                }

                visited[i][j] = true;
                visited[j][i] = true;
                bfs(i, j, computers, visited, done);
                answer++;

                done[i] = true;
                done[j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!done[i]) answer++;
        }

        return answer;
    }

    private static void bfs(int x, int y, int[][] computers, boolean[][] visited, boolean[] done) {
        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        q.add(y);

        System.out.println(x + " " + y);
        while (!q.isEmpty()) {
            int num = q.poll();

            for (int k = 0; k < computers.length; k++) {
                if (num == k || visited[num][k] || computers[num][k] == 0) {
                    visited[num][k] = true;
                    visited[k][num] = true;
                    continue;
                }

                visited[num][k] = true;
                visited[k][num] = true;
                q.add(k);

                done[k] = true;
                done[num] = true;
            }
        }
    }
}