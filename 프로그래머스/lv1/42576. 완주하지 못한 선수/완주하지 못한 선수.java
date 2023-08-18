import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String player :participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        for (String player :completion) {
            map.put(player, map.get(player) - 1);
        }
        
        for (String s: map.keySet()) {
            if(map.get(s) != 0) answer = s;
        }
        return answer;
    }
}