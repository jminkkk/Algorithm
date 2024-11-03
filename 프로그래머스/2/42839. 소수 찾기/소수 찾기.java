import java.util.*;

class Solution {
    static Set<Integer> str = new HashSet<>();
    static String[] nums;
    
    public int solution(String numbers) {
        nums = numbers.split("");
        boolean[] visited = new boolean[nums.length];
        
        dfs(visited, 0, "");
        // System.out.println(str);

        return str.size();
    }
    
    public void dfs(boolean[] visited, int depth,  String now) {
        if (depth != 0 && isPrime(Integer.parseInt(now))) {
            str.add(Integer.parseInt(now));
            // System.out.println(now);
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, depth + 1, now +nums[i]);
                visited[i] = false;
            }
        }
    } 

    public boolean isPrime(int num) {
        if (num == 1 || num == 0) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}
