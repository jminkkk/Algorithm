import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        int[] arr = new int[200_001];
        int[] num = new int[n];

        int max = 0;
        int now = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < n; i++) {
            arr[num[i]]++;
            now++;

            if (arr[num[i]] > k) {
                max = Math.max(max, now - 1);
                while (arr[num[i]] > k) {
                    arr[num[right]]--;
                    now--;
                    right++;
                }
            }
        }

        max = Math.max(max, now);
        System.out.println(max);
        // 1. int 배열 선언
        // 2. -> 이동하면서 나오는 수의 배열에 ++
        // 3. 만약 나오는 수를 계산했을 경우
        // 합이 x개를 초과하면 중단
        // 거기까지의 길이를 최대치와 비교
        // 4. 오른쪽 포인터를 초과되는 수가 처음 나오는 번째 다음으로 이동
        // 이동하면서 지나가는 애들의 배열에서 갯수 제거해주기 + 길이 줄이기
    }
}
