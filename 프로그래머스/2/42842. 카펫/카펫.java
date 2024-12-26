class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int x = 1; x <= Math.sqrt(yellow); x++) {
            int y = yellow / x;
            if (brown + yellow == (x + 2) * (y + 2)) {
                answer[0] = Math.max(x + 2, y + 2);
                answer[1] = Math.min(x + 2, y + 2);
            }
        }
        
        return answer;
    }
}
