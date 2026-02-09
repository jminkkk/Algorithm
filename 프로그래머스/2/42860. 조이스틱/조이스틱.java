class Solution {
    public int solution(String name) {
        int answer = 0;
        
        char[] arr = name.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'A') answer += Math.min(arr[i] - 'A', 26 - (arr[i] - 'A')); // 자리 A로 만들기
        }
        
        int min = name.length();
        for (int i = 0; i < arr.length; i++) { // 다음 위치 구하기
            int next = i + 1;
            
            while (next < name.length() && arr[next] == 'A') next++;
            
            min = Math.min(min, 2 * i + name.length() - next);
            min = Math.min(min, (name.length() - next) * 2 + i);
        }
        
        return answer + min;
    }
}