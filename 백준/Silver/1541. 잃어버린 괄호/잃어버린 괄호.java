import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        // br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1541/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        String[] nums = line.split("-");
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            String[] plusNums = nums[i].split("\\+");

            for (String s : plusNums)
                temp += Integer.parseInt(s);

            if (i == 0) sum += temp;
            else sum -= temp;
        }

        System.out.println(sum);    }
}

// // 먼저 음수 인덱스 구하기
//
/// / 1
//int sum = 0;
//for 1...i
//	sum += arr[i];
//
/// / 2
//int min = sum;
//
//for 1...i
//	// arr 이 음수
//	if (now is "-") {
//		int nowSum = 0;
//		while (다음 음수) nowSum += arr[i++]
//		min = Math.min(min, sum - 2 * nowSum
//	}
//}
//
//sout(min)
