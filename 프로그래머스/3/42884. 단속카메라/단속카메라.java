import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a1, a2) -> a1[1] - a2[1]);
        int left = routes[0][0];
        int right = routes[0][1];
        int answer = 1;
            
        for (int[] r: routes) {
            // System.out.println(left + " " + right);
            // System.out.println(r[0] + " " + r[1]);
            if (left <= r[1] && right >= r[0]) continue;
            
            left = r[0];
            right = r[1];
            answer++;
        }
        
        return answer;
    }
}