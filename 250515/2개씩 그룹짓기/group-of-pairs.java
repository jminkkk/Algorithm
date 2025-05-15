import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(nums);
        // 0 1 2 3 4 5
        int max = nums[0] + nums[2 * n - 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i] + nums[2 * n - 1 - i]);
        }
        System.out.println(max);
    }
}