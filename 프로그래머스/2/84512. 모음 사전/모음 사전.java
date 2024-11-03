import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static String[] arr = new String[]{ "A", "E", "I", "O", "U" };
    public int solution(String word) {
        dfs(0, "");
        
        System.out.println(list);
        return list.indexOf(word);
    }
    
    public void dfs(int count, String str) {
        if (!list.contains(str)) list.add(str);
        if (count == 5) return;
            
        for (int a = 0; a < 5; a++) {
            dfs(count + 1 ,str + arr[a]);
        }

    }
}
// 다 만들고 sort , indexOf 로 알아내기 