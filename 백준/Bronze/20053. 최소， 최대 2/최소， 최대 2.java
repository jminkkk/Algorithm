import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // Test Case의 갯수

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] arr = str.split(" ");
            int max = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[0]);

            for (String j : arr) {
                if(max < Integer.parseInt(j)) max = Integer.parseInt(j);
                if(min > Integer.parseInt(j)) min = Integer.parseInt(j);
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}