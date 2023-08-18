import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        Map<Integer, Integer> phoneketmon = new HashMap<>();
        
        for (int i : nums) {
            phoneketmon.merge(i, 1, (oldValue, aValue) -> oldValue + 1);
        }
        
        if (phoneketmon.size() >= answer) return answer;
            
        return phoneketmon.size();
    }
}