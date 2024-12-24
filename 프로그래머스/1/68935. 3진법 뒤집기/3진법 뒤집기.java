class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        // 1. 3진법 구하기
        while (n != 0) {
            int value = n % 3;
            sb.append(String.valueOf(value));
            n /= 3;
        }
        
        String reverseStr = sb.toString();
        // 2. 10진법으로 만들기
        for (int i = 0; i < reverseStr.length(); i++) {
            int cnt = reverseStr.charAt(i) - '0';
            answer += (Math.pow(3, reverseStr.length() - i - 1) * cnt);
        }
        
        return answer;
    }
}