class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') continue;
            
            if (arr[i] <= 90 && arr[i] + n >= 91) {
                arr[i] += (n - 26);
            } else if (arr[i] + n > 122) { 
                arr[i] += (n - 26);
            } else {
                arr[i] += n;
            }
        }
        
        return new String(arr);
    }
}