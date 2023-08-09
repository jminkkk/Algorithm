
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            System.out.println(solution(br.readLine()));
        }
    }

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        char[] arr = str.toCharArray();
        int idx1 = -1, idx2 = 0;

        // 뒤에서부터 감소하는 곳 찾기
        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                idx1 = i - 1;
                break;
            }
        }

        if (idx1 == -1) return str;

        // 최소값
        for (int i = n - 1; i >= 0; i--) {
            if (arr[idx1] < arr[i]) {
                idx2 = i;
                break;
            }
        }

        // 바꾸기
        char tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

        // 오름차순
        Arrays.sort(arr, idx1 + 1, n);
        for (char c : arr) sb.append(c);

        return sb.toString();
    }
}


