import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int n, t;
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]); // 행
        t = Integer.parseInt(str[1]); // 열
        nums = new ArrayList<>();

        // 1과 1 사이의 구간의 길이 배열 구하기
        int count = 0;
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(str[i]);
            if (num == 1 && count != 0) {
                nums.add(count);
                count = 1;
            } else {
                count++;
            }
        }

        int sum = nums.stream().mapToInt(i -> i).sum();

        int lo = 0;
        int hi = sum; // 최대 구간의 길이
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (canDivideByK(mid)) { // 최대 구간의 길이가 mid일 때 쪼갤 수 있는 구간의 숫자가 t 이하인가?
                hi = mid;
            } else {
                lo = mid;
            }
        }

        System.out.println(hi);
    }

    private static boolean canDivideByK(int mid) {
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            if (num > mid) {
                return false;
            } else if (sum + num > mid) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }

        if (sum != 0) count++;

        return count <= t;
    }
}
