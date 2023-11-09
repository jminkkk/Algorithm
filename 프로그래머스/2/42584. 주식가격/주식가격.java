import java.util.*;

class Solution {
//     public int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];
//         boolean[] isDown = new boolean[prices.length];
        
//         for(int i = 0; i < prices.length; i++) {
//             int now = prices[i];
            
//             for (int j = 0; j < i; j++ ) {
//                 if (!isDown[j]) {
//                         answer[j]++;
//                     if (prices[j] > now) {
//                         isDown[j] = true;
//                     }
//                 }
//             }
//         }
        
//         return answer;
//     }
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                ans[i]++;
                if (prices[i] > prices[j]) 
                    break;

            }
        }

        return ans;
    }
}
