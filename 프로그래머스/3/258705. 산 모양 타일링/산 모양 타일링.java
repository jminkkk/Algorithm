class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int[] a = new int[n + 1]; // 1. <->가 없을 때
        int[] b = new int[n + 1]; // 2. 있을 때 
        
        if (tops[0] == 0) {
            a[0] = 2;
            b[0] = 1;
        } else {
            a[0] = 3;
            b[0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            a[i - 1] %= 10_007;
            b[i - 1] %= 10_007;

            if (tops[i] == 0) {
                a[i] = 2 * a[i - 1] + b[i - 1];
                b[i] = a[i - 1] + b[i - 1];
            } else {
                a[i] = 3 * a[i - 1] + 2 * b[i - 1];
                b[i] = a[i - 1] + b[i - 1];
            }   
        }
        
        answer = (a[n - 1] + b[n - 1]) % 10_007;
        return answer;
    }
}