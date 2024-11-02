// import java.util.*;

// class Solution {
//     public int solution(int[] citations) {
//         Arrays.sort(citations);
//         int answer = citations[citations.length - 1];
        
//         for (int i = 0; i < citations.length; i++) {
//             if (citations[i] >= answer) break;
//                 answer--;
//         }
        
//         return answer;    
//     }
// }

import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = citations.length;
        
        for(int c: citations){
            if(c >= answer){
                break;
            }else{
                answer -= 1;
            }
        }
        return answer;
    }
}
