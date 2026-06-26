import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] c: clothes) {
            int cnt = map.getOrDefault(c[1], 0);
            map.put(c[1], cnt + 1);
        }
        
        for (Map.Entry e: map.entrySet()) {
            answer *= ((Integer) e.getValue() + 1);
        }

        answer -= 1; // 1개도 안입는 경우
        
        return answer;
    }
}