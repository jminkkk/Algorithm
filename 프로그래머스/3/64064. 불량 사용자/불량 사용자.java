import java.util.*;

class Solution {
    
    Set<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        backtracking(user_id, banned_id, 0, new boolean[user_id.length]);
        return set.size();
    }
    
    private void backtracking(String[] user_id, 
                              String[] banned_id,
                              int idx, // 확인해야 하는 banned_id[idx]
                              boolean[] visited) { // 지금까지 불량 아이디로 확인된 유저
        if (idx == banned_id.length) {
            String str = "";
            for (boolean now: visited) str += (now + " ");
            set.add(str);
            return;
        }
        
        String bannedName = banned_id[idx];
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;
            if (!canMatch(bannedName, user_id[i])) continue;
            
            visited[i] = true;
            backtracking(user_id, banned_id, idx + 1, visited);
            visited[i] = false;
        }
    }
    
    private boolean canMatch(String bannedName, String userName) {
        if (bannedName.length() != userName.length()) return false;
        
        for (int i = 0; i < bannedName.length(); i++) {
            if (bannedName.charAt(i) == userName.charAt(i)) continue;
            if (bannedName.charAt(i) == '*') continue;
            return false;
        }
        
        return true;
    }
}
// 조합 구하기
