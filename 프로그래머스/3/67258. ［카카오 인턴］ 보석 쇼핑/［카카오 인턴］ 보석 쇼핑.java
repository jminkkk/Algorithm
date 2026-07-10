
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> cntMap = new HashMap<>();

        int left = 0;
        int right = 0;
        cntMap.put(gems[0], 1);

        int[] min = new int[]{0, gems.length - 1};

        while (left <= right && right < gems.length) {

            if (cntMap.size() == set.size()) {

                if (right - left < min[1] - min[0]) {
                    min = new int[]{left, right};
                }

                cntMap.put(gems[left], cntMap.get(gems[left]) - 1);
                if (cntMap.get(gems[left]) == 0) {
                    cntMap.remove(gems[left]);
                }

                left++;

            } else {

                right++;
                if (right == gems.length) break;

                cntMap.put(gems[right],
                        cntMap.getOrDefault(gems[right], 0) + 1);
            }
        }

        return new int[]{min[0] + 1, min[1] + 1};
    }
}
