import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1, o2) -> { return o1[1] - o2[1]; });
        
        int idx = 0; // 현재 카메라 둔 위치의 경로 인덱스
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= routes[idx][1]) continue;
            
            answer++;
            idx = i;
        }
        
        return answer;
    }
}