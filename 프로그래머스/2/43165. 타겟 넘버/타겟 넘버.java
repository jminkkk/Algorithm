
class Solution {
    static int t, ans = 0;
    static int[] nums;

    public int solution(int[] numbers, int target) {
        t = target;
        nums = numbers;
        
        dfs(0, numbers[0]);
        dfs(0, -1 * numbers[0]);

        return ans;
    }

    // 깊이 우선 탐색
    public void dfs(int depth, int sum){
        if(depth == nums.length - 1) { // 마지막 노드 까지 탐색한 경우
            if(t == sum) ans++;
            return;
        } 
        
        dfs(depth + 1, sum + nums[depth + 1]);
        dfs(depth + 1, sum - nums[depth + 1]);
    }
}