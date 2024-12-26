import java.util.*;

class Solution {
    static int n;
    static List<String> list;
    static String[] arr = new String[]{"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            dfs(arr[i], 1);
        }        
        
        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
    
    private void dfs(String now, int depth) {
        list.add(now);
        
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(now + arr[i], depth + 1);
        }        
    }
}

// 다 만들고 Map
// 단어가 있을 때, 가장 작은 것 붙이기 vs 뒤에꺼 올리기