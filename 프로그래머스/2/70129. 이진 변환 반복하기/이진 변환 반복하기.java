class Solution {
    public int[] solution(String s) {
        int tryCnt = 0;
        int rmCnt = 0;
        
        String str = s;
        while (!str.equals("1")) {
            tryCnt++;
            // 1. 0제거
            for (char c: str.toCharArray()) {
                if (c == '0') rmCnt++;
            }
            str = str.replace("0", "");
            
            // 2. 길이 계산
            int len = str.length();
            
            // 3. 2진수 변환
            str = transBinary(len);
        }
        
        return new int[]{tryCnt, rmCnt};
    }
    
    private String transBinary(int len) {
        StringBuilder sb = new StringBuilder();
        
        while (len != 0) {
            int mok = len % 2;
            len /= 2;
            sb.append(mok);
        }
        
        sb.reverse();
        return sb.toString();
    }
}