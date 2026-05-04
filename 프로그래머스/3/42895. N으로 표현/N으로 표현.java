import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 1; i <= 8; i++) map.put(i, new ArrayList<>());

        map.get(1).add(N);

        for(int i = 2; i <= 8; i++) {
            List<Integer> now = map.get(i);
            
            for (int j = 1; j < i; j++) {
                List<Integer> pre = map.get(j);
                List<Integer> post = map.get(i - j);

                for(int preNum : pre) {
                    for(int postNum : post) {
                        now.add(preNum + postNum);
                        now.add(preNum * postNum);

                        if(preNum - postNum > 0) now.add(preNum - postNum);
                        if(preNum > 0 && postNum > 0) now.add(preNum / postNum);
                    }
                }
                    
            }
            now.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            map.put(i, now);
        }

        for(int i = 1; i <= 8; i++) if(map.get(i).contains(number)) return i;

        return -1;
    }
}