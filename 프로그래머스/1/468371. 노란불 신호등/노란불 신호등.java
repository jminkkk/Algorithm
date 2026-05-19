class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        int max = 1;
        for (int[] signal: signals) {
            int sum = signal[0] + signal[1] + signal[2];
            max *= sum;
        }
        
        for (int i = 0; i <= max; i++) {
            boolean isYellow = true;
            for (int j = 0; j < signals.length; j++) {
                if (!checkYellow(i, signals[j])) {
                    isYellow = false;
                    break;
                }
            }
            
            if (isYellow) return i;
        }
        
        return -1;
    }
    
    public boolean checkYellow(int t, int[] signal) {
        int cycle = signal[0] + signal[1] +  signal[2];
        int now = t % cycle;
        return now > signal[0] && now <= signal[0] + signal[1];
    }
}

// 최소 중복? 주기
// 5 * 7