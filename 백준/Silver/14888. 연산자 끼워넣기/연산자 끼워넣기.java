import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] operator = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        str = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(str[i]);
        }

        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int hap, int depth) {
        if (depth == arr.length) {
            min = Math.min(min, hap);
            max = Math.max(max, hap);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                if (i == 0) {
                    dfs(hap + arr[depth], depth + 1);
                } else if (i == 1) {
                    dfs(hap - arr[depth], depth + 1);
                } else if (i == 2) {
                    dfs(hap * arr[depth], depth + 1);
                } else {
                    dfs(hap / arr[depth], depth + 1);
                }
                operator[i]++;
            }
        }
    }
}