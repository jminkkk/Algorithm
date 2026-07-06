import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        int strLen = begin.length();
        int wordsLen = words.length;
        boolean[][] arr = new boolean[wordsLen][wordsLen];
        
        // 주어진 단어 간 변환 가능한지 마킹 
        for (int i = 0; i < wordsLen; i++) {
            for (int j = 0; j < wordsLen; j++) {
                if (i == j) continue;
                
                int diff = 0;
                for (int k = 0; k < strLen; k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) diff++;
                }
                
                if (diff == 1) {
                    arr[i][j] = true;
                }
            }
        }
        
        // 시작 단어에서 변환 가능한지
        for (int i = 0; i < wordsLen; i++) {
            int diff = 0;
            for (int j = 0; j < strLen; j++) {
                if (words[i].charAt(j) != begin.charAt(j)) diff++;
            }
                
            if (diff == 1) bfs(words, arr, target, i);
        }
        
        answer = answer == Integer.MAX_VALUE ? 0 : answer;
        return answer;
    }
    
    private void bfs(String[] words, boolean[][] arr, String target, int idx) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Node(1, idx));
        visited[idx] = true;
        
        while (!q.isEmpty()) {
            Node nd = q.poll();
            
            if (target.equals(words[nd.idx])) {
                answer = Math.min(answer, nd.depth);
                return;
            }
            
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) continue;
                if (!arr[nd.idx][i]) continue;
                q.add(new Node(nd.depth + 1, i));
                visited[i] = true;
            }
        }
        
    }
}


class Node {
    int depth;
    int idx;
    
    Node(int depth, int idx) {
        this.depth = depth;
        this.idx = idx;
    }
}