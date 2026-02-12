import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int lo = 0;
        int hi = people.length - 1;

        while (lo < hi) {
            int sum = people[hi];
            
            if (lo != hi && sum + people[lo] <= limit) {
                sum += people[lo++];
            }
            
            hi--;
            answer++;
        }
        
        if (hi == lo) answer++;
        return answer;
    }
}