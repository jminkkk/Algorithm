import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 1;
        int len = begin.length();
        boolean[] visited = new boolean[words.length];
        
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (validateDiff(len, words[i], begin)) {
                visited[i] = true;
                q.add(words[i]);
            }
        }

        if (q.size() == 0) return 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            if (q.contains(target)) return answer;            
            
            for (int i = 0; i < size; i++) {
                String now = q.poll();
                
                for (int j = 0; j < words.length; j++) {
                    if (visited[j]) continue;
                    if (!validateDiff(len, now, words[j])) continue;
                    
                    visited[j] = true;
                    q.add(words[j]);
                }
            }
            
            answer++;
            
        }

        return 0;
    }
    
    private boolean validateDiff(int len, String a, String b) {
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        
        return diff == 1;
    }
}