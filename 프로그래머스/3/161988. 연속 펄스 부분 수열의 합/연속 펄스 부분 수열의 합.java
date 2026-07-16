class Solution {
    
    int[][] arr = {
        {1, -1},
        {-1, 1}
    };
    
    public long solution(int[] sequence) {
        long answer = Math.max(calTwoPointer(0, sequence), calTwoPointer(1, sequence));
        return answer;
    }
    
    private long calTwoPointer(int d, int[] sequence) {
        int len = sequence.length;
        long max = Long.MIN_VALUE;

        long[] sum = new long[len + 1];
        for (int i = 1; i < len + 1; i++) {
            if (i % 2 == 0) sum[i] = sum[i - 1] + (sequence[i - 1] * arr[d][0]);
            else sum[i] = sum[i - 1] + (sequence[i - 1] * arr[d][1]);
        }
        
        int left = 0;
        int right = 1;

        // 1 -1 1
        long pre = sum[left];
        while (left <= right && right <= len) {
            long now = sum[right] - sum[left];
            max = Math.max(max, now);
            
            // left 갱신
            if (now < pre) {
                left = right;
                continue;
            }
            
            // right 갱신
            right++;
        }
        
        return max;
    }
}

// 누적합으로 펄스 연산 후 가장 합이 큰 구간 찾기
// 펄스연산은 전체 배열에 고정 X -> 아래 2개 모두 적용하여 최대값 찾기
    // 1 -1 1 -1
    // -1 1 -1 1
