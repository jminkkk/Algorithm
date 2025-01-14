import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] arr = new int[n];
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 1. 구간 구하기
        // 2. 안 겹치면 추가
        // 3. 겹치면 겹치는 구간 조정 m
            // (a, b, c)가 새로 들어왔을 경우 -> log n
            // 1. a보다 큰 구간 있는지 확인, 쪼개기 -> 찾고 넣고 log n
            // 2. 작은 구간 있는지 확인, 쪼개기
        // 4. 마지막 구간들 update, n
        int[] h = new int[n+ 1];
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]) - 1;
            int b = Integer.parseInt(str[1]) - 1;
            int k = Integer.parseInt(str[2]);

            h[a] += k;
            h[b + 1] -= k;
        }

        for (int i = 1; i < n; i++) {
            h[i] += h[i - 1];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + h[i] + " ");
        }
    }
}
