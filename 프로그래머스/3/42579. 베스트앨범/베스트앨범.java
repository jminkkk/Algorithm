import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 0. map 2개 선언
            // 1. 장르별 전체 재생 수 합
            // 2. 장르별 재생 수 높은 순 노래 pq
        Map<String, Integer> sum = new HashMap<>();
        Map<String, PriorityQueue<Node>> cnt = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String curGn = genres[i];
            int curPl = plays[i];
            sum.put(curGn, sum.getOrDefault(curGn, 0) + curPl);
            
            PriorityQueue<Node> pq = cnt.getOrDefault(curGn, new PriorityQueue<Node>());
            pq.add(new Node(i, curPl));
            cnt.put(curGn, pq);
        }
        
        PriorityQueue<Node2> sumQ = new PriorityQueue<>();
        for (Map.Entry entry: sum.entrySet()) {            
            String gerne = (String) entry.getKey();
            int totalSum = (Integer) entry.getValue();
            sumQ.add(new Node2(gerne, totalSum));
        }
        
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[sumQ.size() * 2];
        
        while (!sumQ.isEmpty()) {
            Node2 nd = sumQ.poll();
            PriorityQueue<Node> pq = cnt.get(nd.gerne);
            if (pq.size() >= 1) list.add(pq.poll().idx);
            if (pq.size() >= 1) list.add(pq.poll().idx);
        }
        
        answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int playCnt;
    
    Node(int idx, int playCnt) {
        this.playCnt = playCnt;
        this.idx = idx;
    }
    
    public int compareTo(Node o) {
        return o.playCnt - this.playCnt;
    }
}

class Node2 implements Comparable<Node2> {
    String gerne;
    int sum;
    
    Node2(String gerne, int sum) {
        this.gerne = gerne;
        this.sum = sum;
    }
    
    public int compareTo(Node2 o) {
        return o.sum - this.sum;
    }
}