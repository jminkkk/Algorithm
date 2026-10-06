import java.util.*;

class Solution {
    public int[] solution(String[] gems) {        
        int uniqueCnt = (int) Arrays.stream(gems).distinct().count();
        
        int lo = uniqueCnt - 1;
        int hi = gems.length;

        int result = -1;
        while (lo + 1 < hi) { // O(logN)
            int mid = (lo + hi) / 2;
            
            result = canBuy(mid, gems, uniqueCnt); // O(logN)
            if (result != -1) hi = mid;
            else lo = mid;
        }
        
        result = canBuy(hi, gems, uniqueCnt);        
        
        int[] answer = new int[]{result + 1, result + hi};
        return answer;
    }
    
    // mid 구간안에 unique Count이 들어오는가
    private int canBuy(int mid, String[] gems, long uniqueCnt) { 
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < mid; i++) map.put(gems[i], i);
        
        if (map.size() == uniqueCnt) return 0;
                
        int str = 0;
        int end = mid - 1;

        while (true) { // O(N)
            if (map.get(gems[str]) == str) map.remove(gems[str]);

            str++;
            end++;

            if (end >= gems.length) break;
            map.put(gems[end], end);
            if (map.size() == uniqueCnt) return str; // O(N)
        }

        return -1;
    }
}