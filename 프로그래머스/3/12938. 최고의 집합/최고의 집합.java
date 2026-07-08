class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int o = s / n;
        int gap = s % n;
        
        if (o < 1) return new int[]{-1};
        
        for (int i = n - 1; i >= 0; i--) {
            if (gap > 0) {
                answer[i] += 1;
                gap--;
            }
            answer[i] += o;
        }
        
        return answer;
    }
}

// 1. 합이 s고 길이가 n인 조합 찾기
// 2.