import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (int[] a, int[] b) -> a[0] - b[0]);
        
        // 대상 고르기 위해선
            // 1. 요청 시각이 현재보다 이후
            // 2. 1번을 만족한 것들 중 시간이 제일 빨라야 함
        int nowT = 0;
        int totalT = 0;
        int idx = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        while (idx < jobs.length || !pq.isEmpty()) {
            while (idx < jobs.length && jobs[idx][0] <= nowT) {
                pq.offer(new Node(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (pq.isEmpty()) {
                nowT = jobs[idx][0];
                continue;
            }
            
            Node nd = pq.poll();
            nowT += nd.duration;
            totalT += nowT - nd.reqT;
        }
        
        return totalT / jobs.length;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int reqT;
    int duration;
    
    Node (int idx, int reqT, int duration) {
        this.idx = idx;
        this.reqT = reqT;
        this.duration = duration;
    }
    
    public int compareTo(Node o) {
        if (o.duration != this.duration) return Integer.compare(this.duration, o.duration);
        return Integer.compare(this.idx, o.idx);
    }
}
