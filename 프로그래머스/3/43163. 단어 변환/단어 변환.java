import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int strLen = begin.length();
        int wordsLen = words.length;
        
        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[wordsLen];
        q.add(begin);
        
        while (!q.isEmpty()) {
            int size = q.size();
                        
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (target.equals(str)) {
                    return answer;
                }
                
                for (int j = 0; j < wordsLen; j++) {
                    if (visited[j]) continue;
                    int diff = 0;
                    
                    for (int k = 0; k < strLen; k++) {
                        if (words[j].charAt(k) != str.charAt(k)) diff++;
                    }

                    if (diff != 1) continue;

                    q.add(words[j]);
                    visited[j] = true;
                }
            }
            
            answer++;
        }
        
        return 0;
    }
}
