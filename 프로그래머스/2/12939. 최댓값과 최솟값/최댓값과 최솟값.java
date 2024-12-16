class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] str = s.split(" ");
        
        for (int i = 0; i < str.length; i++) {
            max = Math.max(max, Integer.parseInt(str[i]));
            min = Math.min(min, Integer.parseInt(str[i]));
        }
        
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}