import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);

        int[][] minT = new int[2001][2001];
//        boolean[][] visited = new boolean[2001][2001];
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) minT[i][j] = -1;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 1, 0));

        while (!q.isEmpty()) {
            Node nd = q.poll();
            if (nd.nowEmoticon >= 2001 || nd.nowClipboard >= 2001) {
                continue;
            }

            int nextTime = nd.nowTime + 1;

            // 복사
            if (minT[nd.nowEmoticon][nd.nowEmoticon] == -1) {
                minT[nd.nowEmoticon][nd.nowEmoticon] = nextTime;
                q.add(new Node(nextTime, nd.nowEmoticon, nd.nowEmoticon));
            }

            // 붙여넣기
            if (nd.nowClipboard > 0  && nd.nowClipboard + nd.nowEmoticon <= 2000) {// 처음
                if (minT[nd.nowClipboard + nd.nowEmoticon][nd.nowClipboard] == -1) {
                    minT[nd.nowClipboard + nd.nowEmoticon][nd.nowClipboard] = nextTime;
                    q.add(new Node(nextTime, nd.nowEmoticon +  nd.nowClipboard, nd.nowClipboard));
                }
            }

            // 빼기
            int nextEmoticon = nd.nowEmoticon - 1;
            if (nextEmoticon >= 0) {
                if (minT[nextEmoticon][nd.nowClipboard] == -1) {// 처음
                    minT[nextEmoticon][nd.nowClipboard] = nextTime;
                    q.add(new Node(nextTime, nextEmoticon, nd.nowClipboard));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 2001; i++) {
            if (minT[s][i] != -1) {
                answer = Math.min(answer, minT[s][i]);
            }
        }

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}

class Node {
    int nowTime; // 현재 시간 = 연산 횟수
    int nowEmoticon; // 현재 이모티콘 갯수
    int nowClipboard; // 복붙 횟수

    Node(int nowTime, int nowEmoticon, int nowClipboard) {
        this.nowTime = nowTime;
        this.nowEmoticon = nowEmoticon;
        this.nowClipboard = nowClipboard;
    }
}
