import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        // n 시간 안에 주어진 사람이 심사 완료 가능한가
        long lo = 0;
        long hi = (long) times[times.length - 1] * n; // 가장 오래 걸리는 심사관에 모두 할당된 시간
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            
            if (canEvaluate(mid, n, times)) hi = mid;
            else lo = mid;
        }
        
        return hi;
    }
    
    private boolean canEvaluate(long t, int n, int[] times) {
        long cnt = 0; 
        
        for (int time: times) {
            cnt += (t / time);
            if (cnt >= n) return true;
        }
        
        return false;
    }
}