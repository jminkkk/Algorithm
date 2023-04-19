import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    // N명의 고리 회원이 치킨 주문
    // 치킨은 총 M가지 종류, 회원마다 특정 치킨의 선호도
    // 한 사람의 만족도는 시킨 치킨 중에서 선호도가 가장 큰 값으로 결정
    // 회원들의 만족도 최대가 되도록
    // 최대 3가지만

    static List<Integer> maxPrefer;
    static String[] NM;
    static int M;
    static int N;
    static String[][] preferArr;
    static Integer[][] prefer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        // 고리 회원의 수 N, 치킨 종류의 수 M
        NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]); // 회원 N
        M = Integer.parseInt(NM[1]); // 치킨 종류 M
        preferArr = new String[N][];

        for (int i = 0; i < N; i++) {
            preferArr[i] = br.readLine().split(" ");
        }

        prefer = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                prefer[i][j] = Integer.parseInt(preferArr[i][j]);
            }
        }

        maxPrefer = new ArrayList<>();

        // M < 3 다 시킴
        if (M >= 3) {
            for (int i = 0; i < M; i++) {
                for (int j = i + 1; j < M; j++) {
                    for (int k = j + 1; k < M; k++) {
                        maxPrefer.add(최대만족도(i, j, k));
                    }
                }
            } // 각 치킨 조합에 따른 사람들의 만족도 합

            Collections.sort(maxPrefer);
            System.out.println(maxPrefer.get(maxPrefer.size() - 1));

        } else if (M == 2) {
            int sum = 0;

            for (int i  = 0; i < N; i++) {
                if (prefer[i][0] > prefer[i][1]) sum += prefer[i][0];
                else sum += prefer[i][1];
            }

            System.out.println(sum);
        }

        else { // M == 1
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += prefer[i][0];
            }

            System.out.println(sum);
        }
    }

    // 만족도의 합의 최댓값
    public static int 최대만족도(int a, int b, int c) {
        int sum = 0; // 시키는 치킨들 번호
        for (int i = 0; i < N; i++) {
            IntStream intStream = IntStream.of(prefer[i][a], prefer[i][b], prefer[i][c]);
            int maxPerPerson = intStream.max().getAsInt();
            // System.out.println(i + "번째 사람의 최대 만족도는: " + maxPerPerson);
            sum += maxPerPerson;
            // System.out.println(sum);
        }

        // System.out.println(a + ", " + b + ", " + c + "의 조합에 따른 만족도의 합 : " + sum);
        // 해당 조합의 치킨들에 따른 N명의 만족도의 합
        return sum;
    }
}
