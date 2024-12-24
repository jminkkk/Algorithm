class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        // O(N)
        // 1. 길이 정하기
        // 2. 자른 문자열을 체크 O(N)
            // 2-1. 이전과 같다면 cnt ++
            // 2-2. 이전과 다르다면 sb.append
        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i);
            int count = 1;
            
            for (int j = i; j < s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());
                String now = s.substring(j, endIdx);
                if (now.equals(str)) {
                    count++;
                } else if (count == 1) {
                    sb.append(str);
                    str = now;
                } else {
                    sb.append(count);
                    sb.append(str);
                    str = now;
                    count = 1;
                }
            }
            
            if (count == 1) {
                sb.append(str);
            } else {
                sb.append(count);
                sb.append(str);
            }
            
            String zip = sb.toString();
            answer = Math.min(answer, zip.length());
        }
        
        return answer;
    }
}