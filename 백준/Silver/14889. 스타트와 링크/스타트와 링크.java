
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer N;
    static int answer = 1000000000;
    static boolean[] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 스타트 링크에 다니는 사람들 축구
        // N명(짝수) 모여서 N/2씩 팀
        // 나올 수 있는 팀의 조합 -> (N!/(N/2)! * (N/2)!)/2
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        combi(0, 0);

        System.out.println(answer);
    }

    public static void combi(int index, int count) {
        // 인덱스와 재귀의 깊이
        if (count == N/2) {

        // start 팀 계산
        int start = 0;
        // link 팀 계산
        int link = 0;

        // 방문한팀, 방문하지 않은 팀 -> 최소값 계산
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    // start 팀 계산
                    if (visit[i] && visit[j]) {
                        start += arr[i][j];
                        start += arr[j][i];
                    }
                    // link 팀 계산
                    if (!visit[i] && !visit[j]) {
                        link += arr[i][j];
                        link += arr[j][i];
                    }
                }
            }

            int cha = Math.abs(start - link);
            answer = Math.min(answer, cha);
            return;
        }

        // 아직 조합 중
        for(int i = index; i < N; i++) {
            if(!visit[i]) {
                // 방문 처리
                visit[i] = true;
                // 인덱스++,  깊이++
                combi(i + 1, count + 1);

                visit[i] = false;
            }
        }
    }
}
