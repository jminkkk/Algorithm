import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> inProgressIdx = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) inProgressIdx.offer(i); // N
        
        int days = 0;
        while (!inProgressIdx.isEmpty()) { // logN
            int cnt = 0;
            
            while (!inProgressIdx.isEmpty()) {
                int nowIdx = inProgressIdx.peek();
                if (progresses[nowIdx] + speeds[nowIdx] * days < 100) break;
                
                inProgressIdx.poll();
                cnt++;
            }
            
            days++;
            if (cnt != 0) answer.add(cnt);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

// 기능 -> 진도 100일 때 반영
// 기능 개발 속도는 다름, 앞 기능보다 개발 일찍될 수 있으나 배포는 기다렸다가 같이 배포
// 진도 배열, 몇개의 기능이 배포되는지 반환
    // 작업의 진도와 속도
