import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int H;
    static int W;
    static Integer[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] WH = br.readLine().split(" ");
        H = Integer.parseInt(WH[0]);
        W = Integer.parseInt(WH[1]);
        String[] heightStr = br.readLine().split(" ");
        height = new Integer[W];

        List<Integer> start = new ArrayList<>(), finish = new ArrayList<>();
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(heightStr[i]);
        }

        int sum = 0;
        for(int i = 1; i < W - 1; i++) { 
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            for(int j = i + 1; j < W; j++) {
                right = Math.max(height[j], right);
            }

            if(height[i] < left && height[i] < right)
                sum += Math.min(left, right) - height[i];
        }

        System.out.println(sum);
    }
}
