import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int len = A.length;
        // b 큰 수를 낭비 없이 a 이기는 것에 사용해야 함
        // b가 이기면 양쪽 큰수 차감
        // b가 지거나 비기면 차라리 b는 작은 수 차감
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int start = 0;
        int end = len - 1;
        
        if (A[start] >= B[end]) return 0;
        
        for (int i = len - 1; i >= 0; i--) {
            if (A[i] < B[end]) {
                answer++;
                end--;
            } else {
                start++;
            }
        }
        
        return answer;
    }
}