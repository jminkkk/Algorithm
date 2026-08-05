class Solution {
    public int solution(String s) {
        for (int len = s.length(); len > 0; len--) {
            for (int str = 0; str <= s.length() - len; str++) {
                boolean allPass = true;
                
                for (int i = 0; i < len / 2; i++) {
                    if (s.charAt(i + str) == s.charAt(len + str - i - 1)) continue;
                    allPass = false;
                    break;
                }
                
                if (allPass) return len;
            }
        }

        return 0;
    }
}