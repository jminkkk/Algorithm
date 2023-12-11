import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] answer = new int[N];
        
        int index1 = 0;
        int index2 = 1;
        int index3 = N - 1;
        // N에 1번째거를 한거
        for (int i = N; i > 0; i--) {
            int index = N - i;
            if (arr[index].equals("1")) {
                answer[index1] = i;
                // 비어있어야함
                if (index1 + 1 < N && answer[index1 + 1] == 0) {
                    index1++;
                } else {
                    index1 = index2 + 1;
                }
            } else if (arr[index].equals("2")) {
                if (answer[index1 + 1] == 0) {
                    index2 = index1 + 1;
                } else {
                    index2 += 1;
                }
                answer[index2] = i;
            } else {
                answer[index3--] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i: answer) {
            sb.append(i + " ");
        }

        System.out.print(sb.toString());
    }
}