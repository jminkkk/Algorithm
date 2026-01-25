import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long maxT = Arrays.stream(times) // 최대 100,000
                        .max()
                        .orElse(0);
        
        long high = maxT * n + 1;
        long low = 0;
        
        while (true) {
            if (low + 1 == high) break;
            long mid = (high + low) / 2;
            
            // 불가능 가능
            if (canJubge(n, times, mid)) high = mid;
            else low = mid;
        }
        
        return high;
    }
    
    public boolean canJubge(int n, int[] times, long t) {
        long totalHuman = n; 
        
        for (int i = 0; i < times.length; i++) {
            totalHuman -= (t / times[i]);
            
            if (totalHuman <= 0) return true;
        }
        
        return false;
    }
}