
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] operator = new int[4]; // + - * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Integer[] nums;
    static Integer N;
    public static void main(String[] args) throws IOException {
        // sort -> 작은 거, /, + 큰거 *
        // + * 543

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 수의 개수
        String[] As = br.readLine().split(" "); // 수
        String[] oper = br.readLine().split(" "); // 연산자

        nums = new Integer[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(As[i]);
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(oper[i]);
        }

        dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int index) {
        if (index == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:	dfs(num + nums[index], index + 1);	break;
                    case 1:	dfs(num - nums[index], index + 1);	break;
                    case 2:	dfs(num * nums[index], index + 1);	break;
                    case 3:	dfs(num / nums[index], index + 1);	break;
                }
                operator[i]++;
            }
        }
    }
}
