import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long lo = 0;
        long hi = (long) Arrays.stream(times).max().getAsInt() * n;
        
        while (lo + 1 < hi) { // nnnny
            long mid = (lo + hi) / 2;
            if (canJudge(times, mid, n)) hi = mid;
            else lo = mid;
        }
        
        return hi;
    }
    
    private boolean canJudge(int[] times, long mid, int n) { // 시간 안에 심사 가능한지
        long cnt = 0;
        for (int t: times) {
            cnt += Math.ceil(mid / t);
        } 
        
        return cnt >= n;
    }
}