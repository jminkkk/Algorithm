import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        List<Integer> reserves = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        List<Integer> losts = Arrays.stream(lost).boxed().collect(Collectors.toList());
        
        List<Integer> hs = new ArrayList<>();
        for (int i: losts) {
            if (reserves.contains(i)) {
                reserves.remove((Integer) i);
                hs.add(i);
            }
        }
        
        losts.removeAll(hs);
        Collections.sort(losts);
        
        for (int i: losts) {
            if (reserves.contains(i - 1)) {
                reserves.remove((Integer) (i - 1));
            } else if (reserves.contains(i + 1)) {
                reserves.remove((Integer) (i + 1));
            } else {
                answer++;
            }
        }
        
        return n - answer;
    }
}
