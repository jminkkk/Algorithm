import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] leased = new boolean[n + 1];
        
        for (int num: reserve) {
            leased[num] = true; // 빌려줄 수 있음
        }
        
        List<Integer> lostList = Arrays.stream(lost)
                                        .boxed()
                                        .sorted()
                                        .collect(Collectors.toList());

        for (int num: lost) { // 자기 옷이 도난 당했지만, 여벌 있는 경우 먼저 체크 
            if (leased[num]) { 
                leased[num] = false;
                lostList.remove((Integer) num);
            }
        }
        
        // System.out.println(lostList);
        
        for (int num: lostList) {
            if (num >= 1 && leased[num - 1]) { // 현재 기준 앞사람 옷 빌림
                leased[num - 1] = false;
                continue;
            }
            
            if (num < n && leased[num + 1]) { // 현재 기준 뒷사람 옷 빌림
                leased[num + 1] = false;
                continue;
            }
            
            answer++;
        }
        return n - answer;
    }
}