import java.util.*;
import java.awt.*;

class Solution {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    
    public int solution(String[] maps) {
        // 특정 구간 통과해서 다음 구간 가기
        // BFS(시작지점 -> 레버) + BFS(레버 -> 출구)
        // 이전 BFS에서 방문한 구간을 뒷 BFS에서 방문
        int rlen = maps.length;
        int clen = maps[0].length();
        boolean[][] bolmap = new boolean[rlen][clen];
        int[] source = new int[2];
        int[] lever = new int[2];
        int[] target = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            char[] arr = maps[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'S') {
                    source = new int[]{i, j};
                    bolmap[i][j] = true;
                } else if (arr[j] == 'E') {
                    target = new int[]{i, j};
                    bolmap[i][j] = true;
                } else if (arr[j] == 'L') {
                    lever = new int[]{i, j};
                    bolmap[i][j] = true;
                } else if (arr[j] == 'O') {
                    bolmap[i][j] = true;
                } else {
                    bolmap[i][j] = false;
                }
            }
        }
        
        int sourceToLever = bfs(source, lever, bolmap);
        int leverToTarget = bfs(lever, target, bolmap);
        
        if (leverToTarget == -1 || sourceToLever == -1) return -1;
        
        return sourceToLever + leverToTarget;
    }
    
    private int bfs(int[] source, int[] target, boolean[][] bolmap) {

        boolean[][] visited = new boolean[bolmap.length][bolmap[0].length];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(source[0], source[1]));
        visited[source[0]][source[1]] = true;
        
        int answer = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point p = q.poll();                
                
            
                if (p.x == target[0] && p.y == target[1]) {
                    return answer;
                }
                
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    
                    if (nx < bolmap.length && ny < bolmap[0].length 
                        && nx >= 0 && ny >= 0 && !visited[nx][ny] && bolmap[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            
            answer++;
        }
        
        return -1;
    }
}

// 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 
// 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 
// 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 
