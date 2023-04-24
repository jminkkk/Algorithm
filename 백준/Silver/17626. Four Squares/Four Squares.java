
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    // 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현 가능
    // 어떤 자연수는 복수의 방법으로 표현
    // 26 = 5^2 + 1^2

    // 자연수 n이 주어질 때, n을 최소 개수의 제곱합으로 표현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    public static int solution(int n) {

        for (int i = 0; i * i <= n; i++) {
            if (n == i * i) return 1;
        }

        for (int i = 0; i * i <= n; i++) {
            for (int j = 0; j * j <= n; j++) {
                if (n == (i * i) + (j * j)) return 2;
            }
        }

        for (int i = 0; i * i <= n; i++) {
            for (int j = 0; j * j <= n; j++) {
                for (int k = 0; k * k <= n; k++) {
                    if (n == (i * i) + (j * j) + (k * k)) return 3;
                }
            }
        }

        return 4;
    }
}
