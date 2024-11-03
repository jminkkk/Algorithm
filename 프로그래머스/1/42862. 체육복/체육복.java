import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        List<Integer> losts = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserves = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        
        Collections.sort(losts);
        Collections.sort(reserves);
        
        List<Integer> rms = new ArrayList<>();
        for (int i : losts) {
            if (reserves.contains(i)) {
                rms.add(i); 
            }
        }
        losts.removeAll(rms);
        reserves.removeAll(rms);
        
        for (Integer i : losts) {
            if (reserves.contains(i - 1)) {
                reserves.remove((Integer) (i - 1)); 
                continue;
            }

            if (reserves.contains(i + 1)) {
                reserves.remove((Integer) (i + 1)); 
                continue;
            }
            answer++;
        }
        
        return n - answer;
    }
}