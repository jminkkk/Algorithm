import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        // dp[i] = n을 i번 사용했을 때 가능한 수 목록
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        for (int count = 1; count <= 8; count++) {
            dp.add(new HashSet<>());
            
            // 계산 안해도 되는 거 ex) "NN" "NNN"
            int repeat = 0; 
            for (int i = 0; i < count; i++) {
                repeat = repeat * 10 + N;
            }
            dp.get(count).add(repeat);
            
            
            // count = i + j
            for (int i = 1; i <= count; i++) {
                int j = count - i;
                
                for (int a : dp.get(i)) {
                    for (int b : dp.get(j)) {
                        dp.get(count).add(a * b);
                        dp.get(count).add(a + b);
                        dp.get(count).add(a - b);
                        
                        if (b != 0) dp.get(count).add(a / b);
                    }
                }
            }
            
            if (dp.get(count).contains(number)) return count;
        }
        
        return -1;
    }
}