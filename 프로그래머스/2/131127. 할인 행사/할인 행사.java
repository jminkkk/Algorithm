import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantAndIdx = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantAndIdx.put(want[i], i);
        }
        
        int cnt = 0;
        for (int i = 0; i < number.length; i++) {
            cnt += number[i];
        }
        
        int[] copyNumber = number.clone();
        int start = 0;
        int end = 0;
        while (end < start + cnt) {
            String nowDis = discount[end++];
            
            if (wantAndIdx.containsKey(nowDis)) {
                int idx = wantAndIdx.get(nowDis);
                copyNumber[idx]--;
            }
        }
        
        int answer = 0;
        while (end < discount.length) {
            // 검증            
            if (isValid(copyNumber)) {
                answer++;
            }

            // 왼쪽으로 한칸 이동
            String strWantDis = discount[start++];
            if (wantAndIdx.containsKey(strWantDis)) {
                int idx = wantAndIdx.get(strWantDis);
                copyNumber[idx]++;
            }

            String endWantDis = discount[end++];
            if (wantAndIdx.containsKey(endWantDis)) {
                int idx = wantAndIdx.get(endWantDis);
                copyNumber[idx]--;
            }
        }

        if (isValid(copyNumber)) {
                answer++;
        }

        
        
        return answer;
    }
    
    private boolean isValid(int[] copyNumber) {
        for (int n : copyNumber) {
            if (n > 0) return false;
        }
        return true;
    }
}

// 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나
// 2중 포문 -> 구간마다 만족하는지 체크 -> 구간 O(discount.len - want.len) * O(want.len * number.sum)
// 100,000 * 100
