class Solution {
    public int solution(int[][] sizes) {

        int MaxW = 0, MaxH = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int x = sizes[i][0];
            int y = sizes[i][1];

            if (x < y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            
            // 못 넣는 경우
            if (x  > MaxW) MaxW = x;
            if (y > MaxH) MaxH = y;
        }
        
        return MaxW * MaxH;
    }
}