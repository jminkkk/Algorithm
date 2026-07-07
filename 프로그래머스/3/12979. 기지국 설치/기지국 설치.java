class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 기지국 신규로 놓았을 때 커버 구간 1 + (2 * w)
        // 기지국 간의 거리 % (2w + 1)
        int len = 2 * w + 1;
        int left = 1; // 직전 기지국 위치
        
        for (int station: stations) {
            int diff = (station - w) - left;
            
            if (diff > 0) {
                answer += (int) Math.ceil((double) diff / len);
            }
            
            left = station + w + 1;
        }
        int diff = n - left + 1;

        if (diff > 0) {
            answer += (int) Math.ceil((double) diff / len);;
        }

        return answer;
    }
}