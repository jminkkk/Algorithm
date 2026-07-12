import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int lo = 0; // yyyn
        int hi = Arrays.stream(stones).max().getAsInt() + 1; 
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            
            if (isAvaliable(stones, k, mid)) lo = mid;
            else hi = mid;
        }
        
        return lo;
    }
    
    private boolean isAvaliable(int[] stones, int k, int value) {
        int cnt = 0;
        for (int s: stones) {
            if (cnt >= k) return false;
            if (s - value < 0) cnt++;
            else cnt = 0;
        }
        
        return cnt < k;
    }
}