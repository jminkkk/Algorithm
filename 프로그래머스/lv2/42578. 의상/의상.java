import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> closeAndName = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            closeAndName.merge(clothes[i][1], 1, (oldValue, newValue) -> oldValue + newValue);
        }
        
        for (int value : closeAndName.values()) {
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}