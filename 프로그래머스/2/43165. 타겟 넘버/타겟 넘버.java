class Solution {
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, numbers[0]);
        dfs(numbers, target, 0, numbers[0] * -1);
        return cnt;
    }
    
    private void dfs(int[] numbers, int target, int idx, int sum) {
        if (numbers.length <= idx + 1) {
            if (sum == target) cnt++;
            return;
        }
        
        dfs(numbers, target, idx + 1, sum + numbers[idx + 1]);
        dfs(numbers, target, idx + 1, sum - numbers[idx + 1]);
    }
}

// dfs
// [+4, -1, +2, -1]
// [+4, +1, 2, 1]
// [4, 1, 2, 1]
