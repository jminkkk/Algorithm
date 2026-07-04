import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> st = new Stack<>();
        String[] str = s.split("");
        for (String now: str) {
            if (now.equals("(")) {
                st.push(now);
                continue;
            }
            
            if (st.isEmpty()) return false;
            
            st.pop();
        }
        
        if (st.isEmpty()) return true;

        return false;
    }
}