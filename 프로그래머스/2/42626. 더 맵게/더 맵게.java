import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s: scoville) pq.offer(s);
        
        while (pq.peek() < K) {
            if (pq.size() <= 1) return -1;
            
            int firstSmallNum = pq.poll();
            int secondSmallNum = pq.poll();
            int newNum = firstSmallNum + secondSmallNum * 2;
            pq.offer(newNum);
            answer++;
        }
        
        return answer;
    }
}

// 모든 음식의 모든 지수가 K이상이 될 때까지 다음 반복
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

// K = 7 [1, 2, 3, 9, 10, 12]
    // 1 + 2 * 2, 3, 9, 10, 12
// 3, 5, 9, 10, 12
    // 3 + 5 * 2, 9, 10, 12
// 13, 9, 10, 12

// while (가장 작은 음식 < K) {
//   섞기
// }
