import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (int[] a, int[] b) -> a[0] - b[0]);
        int idx = 0;
        int cnt = 0;
        int t = 0;
        int avT = 0;
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= t) q.offer(new Node(idx, jobs[idx][0], jobs[idx++][1]));
            
            if (q.isEmpty()) {
                t = jobs[idx][0];
                continue;
            }
            
            Node now = q.poll();
            t += now.duration;
            avT += (t - now.t);
            cnt++;
        }

        answer = avT / jobs.length;
        return answer;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int t;
    int duration;
    
    Node(int idx, int t, int duration) {
        this.idx = idx;
        this.t = t;
        this.duration = duration;
    }
    
    public int compareTo(Node o) {
        if (this.duration != o.duration) return Integer.compare(this.duration, o.duration);
        if (this.t != o.t) return Integer.compare(this.t, o.t);
        return Integer.compare(this.idx, o.idx);
    }
}