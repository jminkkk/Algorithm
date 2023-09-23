import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer N, K;
    static String[] words;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);
        words = new String[N];
        visited = new boolean[26];

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        /* 무조건 배워야하는 단어 */
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        // 5거나 그 이상
        // anta, tica 제거
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", "");
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int alpha, int count) {
        if (count == K - 5) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;

                for (int j = 0; j < words[i].length(); j++) {
                    /* 배우지않은 알파벳이 있는 경우 */
                    if (!visited[words[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp++;
                }
            }
            answer = Math.max(temp, answer);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
    }
}
