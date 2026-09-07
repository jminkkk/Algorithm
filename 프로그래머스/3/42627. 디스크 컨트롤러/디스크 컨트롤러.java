import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        int nowT = 0;
        int idx = 0;
        
        while (!pq.isEmpty() || idx < jobs.length) {

            while (idx < jobs.length && nowT >= jobs[idx][0]) { // 대상건 넣기
                pq.add(jobs[idx++]);
            }
            
            if (pq.isEmpty()) { // 시간 점프
                nowT = jobs[idx][0];
                continue;
            }
            
            int[] now = pq.poll();
            answer += (nowT + now[1] - now[0]);
            nowT += now[1];
            
        }
        
        return answer / jobs.length;
    }
}

// 현재 시간 기준
    // 들어온 애들 확인
    // 애들 중 시간 짧은 거 확인