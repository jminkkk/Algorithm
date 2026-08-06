class Solution {
    public int solution(String s) {
        int answer = 1;

        for (int ctr = 0; ctr < s.length() - 1; ctr++) {
            answer = Math.max(answer, checkLen(s, ctr, ctr));    
            answer = Math.max(answer, checkLen(s, ctr, ctr + 1));
        }
        
        return answer;
    }

    private int checkLen(String s, int leftIdx, int rightIdx) {
        while (leftIdx >= 0
              && rightIdx < s.length()
              && s.charAt(leftIdx) == s.charAt(rightIdx)) {
            leftIdx--;
            rightIdx++;
        }
        
        return rightIdx - leftIdx - 1;
    }
}