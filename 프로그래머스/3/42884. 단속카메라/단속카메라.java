import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (int a[], int b[]) -> a[1] - b[1]);
        int lastCamera = routes[0][1];
        int answer = 1;
        
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > lastCamera) {
                answer++;
                lastCamera = routes[i][1];
            }
        }

        return answer;
    }
}
