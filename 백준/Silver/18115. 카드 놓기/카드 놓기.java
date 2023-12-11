
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int[] answer = new int[N];
        int index1 = 0;
        int index2 = 1;
        int index3 = N - 1;

        for (int i = N; i > 0; i--) {
            int arrIndex = N - i;

            if (arr[arrIndex].equals("1")) {
                answer[index1] = i;
                if (index1 + 1 < N && answer[index1 + 1] == 0) {
                    index1++;
                }
                else index1 = index2 + 1;;
            } else if (arr[arrIndex].equals("2")) {
                if (answer[index1 + 1] == 0) {
                    index2 = index1 + 1;
                } else index2 += 1;
                answer[index2] = i;
            } else if (arr[arrIndex].equals("3")) {
                answer[index3--] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
