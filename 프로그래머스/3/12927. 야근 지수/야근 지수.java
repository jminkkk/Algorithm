import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work: works) pq.add(work);
        
        for (int i = 0; i < n; i++) {
            int now = pq.poll();
            if (now > 0) pq.add(now - 1);
            else pq.add(0);
        }
        
        long answer = 0;
        for (int now: pq) answer += now * now;
        return answer;
    }
}