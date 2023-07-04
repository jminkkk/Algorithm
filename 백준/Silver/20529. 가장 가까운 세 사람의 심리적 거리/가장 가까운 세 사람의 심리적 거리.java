
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 가장 가까운 세 사람의 심리적 거리
public class Main {
    // 테스트 케이스 T
    // 학생 후 N,
    // 엠비티아이 각각의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // T
        int[] arr = new int[T];

        for (int i = 0; i < T; i++) {
            Integer N = Integer.parseInt(br.readLine()); // N
            String MBTIs = br.readLine();
            String[] mbti = MBTIs.split(" ");

            int result = checkThreeNum(mbti);
            arr[i] = result;
        }

        // 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int checkThreeNum(String[] mbti) {
        if (mbti.length > 33) return 0;
        int min = 8; // 최대값이 8

        for (int j = 0; j < mbti.length; j++) {
            for (int k = j + 1; k < mbti.length; k++) {
                for (int l = k + 1; l < mbti.length; l++) {
                    int sum = 0;

                    for (int i = 0; i < 4; i++) {
                        if (mbti[j].charAt(i) != mbti[k].charAt(i) || mbti[k].charAt(i) != mbti[l].charAt(i)) sum += 2;
                    }

                    if (min > sum) min = sum;
                }
            }
        }
        return min;
    }
}
