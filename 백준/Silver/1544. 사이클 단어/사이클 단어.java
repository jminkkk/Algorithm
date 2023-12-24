
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        List<String> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();

            if (!list.contains(arr[i])) {
                count++;
                list.add(arr[i]);
                for (int j = 0; j < arr[i].length(); j++) {
                    String newStr = arr[i].substring(j, arr[i].length()) + arr[i].substring(0, j);
                    list.add(newStr);
                }
            }
        }

        System.out.println(count);
    }
}