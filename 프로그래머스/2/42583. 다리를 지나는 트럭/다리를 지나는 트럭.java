import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 모든 다리가 건너는 최소 시간
        // 다리 트럭 최대 bridge_length 대 == 각 트럭이 다리를 통과할 때까지 걸리는 시간
        // 다리는 weight 이하까지의 무게 견디기 가능
        int cnt = 0;
        int nowIdx = 0;
                
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) q.offer(-1);

        int nowT = 1;
        int sum = 0;
        while (!q.isEmpty()) {            
            int outboundTruckIdx = q.poll();

            // 트럭 빼기
            if (outboundTruckIdx != -1) {
                int outboundTruckWeight = truck_weights[outboundTruckIdx];
                sum -= outboundTruckWeight;
            }
            
            // 마지막 트럭이었다면 종료
            if (outboundTruckIdx == truck_weights.length - 1) {
                break;
            }
            
            // 트럭 추가, 대상 트럭 없으면 빈값 넣기 
            if (nowIdx < truck_weights.length && sum + truck_weights[nowIdx] <= weight) {
                sum += truck_weights[nowIdx];
                q.offer(nowIdx++);
            } else {
                q.offer(-1);
            }
            
            // 시간 증가
            nowT++;
            
        }
        
        return nowT;
    }
}

// 다리에 올라간 트럭은 다리 길이만큼 이동 시간 걸림 -> 이동 시간 처리
// 무게 초과로 다리에 못 올라간다면 지금 올라간 트럭이 끝날 때 이동
// 반복문에서 체크해야 하는 것
    // 종료 조건: 모든 트럭이 건너갔는지 (건너갔는지 어케 체크함)
    // 가장 일찍 탄 트럭 내보내기
    // 무게가 가능하다면 한대 더 태우기

// 12시~
// 3분 확인
// 12분 풀기
// 5분 경계 확인