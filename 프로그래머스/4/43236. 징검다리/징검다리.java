import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canMake(mid, rocks, distance, n)) {
                answer = mid;      // 가능하면 더 키워본다
                left = mid + 1;
            } else {
                right = mid - 1;   // 불가능하면 줄인다
            }
        }

        return answer;
    }

    private boolean canMake(int minDist, int[] rocks, int distance, int n) {
        int removed = 0;
        int prev = 0; // 출발 지점

        for (int rock : rocks) {
            if (rock - prev < minDist) {
                removed++;  // 이 바위 제거
            } else {
                prev = rock;
            }
        }

        // 도착 지점 체크
        if (distance - prev < minDist) {
            removed++;
        }

        return removed <= n;
    }
}
