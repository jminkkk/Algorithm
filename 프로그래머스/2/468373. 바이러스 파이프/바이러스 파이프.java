import java.util.*;

class Solution {
    static List<Integer>[] listA;
    static List<Integer>[] listB;
    static List<Integer>[] listC;
    static int max = 0;
    static int[] dt = {1, 2, 3};
    
    public int solution(int n, int infection, int[][] edges, int k) {
        listA = new ArrayList[n + 1];
        listB = new ArrayList[n + 1];
        listC = new ArrayList[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            listA[i] = new ArrayList<>();
            listB[i] = new ArrayList<>();
            listC[i] = new ArrayList<>();
        }
        
        for (int[] e: edges) {
            List<Integer>[] graph = finType(e[2]);
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        for (int t: dt) {
            Set<Integer> infecSet = new HashSet<>();
            infecSet.add(infection);
            dfs(t, 0, infecSet, k);
        }
        
        return max;
    }
    
    public void dfs(int type, int cnt, Set<Integer> infecSet, int k) {
        if (cnt == k) {
            max = Math.max(max, infecSet.size());
            return;
        }        
       
        // System.out.println(cnt);
        // System.out.println(type + " " + infecSet);
        Set<Integer> nInfecSet = spread(type, infecSet);
        // System.out.println(type + " " + nInfecSet);
        // System.out.println("===================");
        
        for (int t: dt) dfs(t, cnt + 1, nInfecSet, k);
    }
    
    public Set<Integer> spread(int type, Set<Integer> set) {
        List<Integer>[] graph = finType(type);
        
        Set<Integer> infecSet = new HashSet<>(set);
        boolean[] visited = new boolean[graph.length + 1];
        Queue<Integer> q = new LinkedList<>();
        q.addAll(infecSet);
        
        for (int now : infecSet) visited[now] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            List<Integer> list = graph[now]; // 감염된 애들이랑 인접한 애들
            
            for (int next: list) {
                infecSet.add(next);
                
                if (visited[next]) continue;
                q.add(next);
                visited[next] = true;
            }
        }
        
        return infecSet;
    }
    
    public List<Integer>[] finType(int type) {
        if (type == 1) return listA;
        if (type == 2) return listB;
        return listC;
    }
}