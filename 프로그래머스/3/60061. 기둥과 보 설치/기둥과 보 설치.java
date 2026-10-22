import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {        
        boolean[][][] visited = new boolean[n + 1][n + 1][2];
        
        for (int[] bf: build_frame) {
            int r = bf[1];
            int c = bf[0];
            int type = bf[2];
            int delete = bf[3];
            
            if (type == 0 && delete == 0) { // 기둥 삭제 
                if (canDeleteKidoong(n, r, c, visited)) visited[r][c][0] = false;
            } else if (type == 0 && delete == 1) { // 기둥 설치
                if (canInstallKidoong(n, r, c, visited)) visited[r][c][0] = true;
            } else if (type == 1 && delete == 0) { // 보 삭제
                if (canDeleteVo(n, r, c, visited)) visited[r][c][1] = false;
            } else { // 보 설치
                if (canInstallVo(n, r, c, visited)) visited[r][c][1] = true;
            }
        }
        
        List<int[]> list = new ArrayList<>();
        for (int c = 0; c <= n; c++) {
            for (int r = 0; r <= n; r++) {
                if (visited[r][c][0]) list.add(new int[]{c, r, 0});
                if (visited[r][c][1]) list.add(new int[]{c, r, 1});
            }
        }
        
        int[][] answer = list.toArray(new int[0][]); // list.stream().map(i -> i).toArray();
        
        return answer;
    }
        
    public boolean canDeleteKidoong(int n, int r, int c, boolean[][][] visited) {
        // 이미 없으면 못지움
        if (!visited[r][c][0]) return false;
        
        // 이거 지웠을 때 영향 가는 애들 다 통과이면 삭제 가능
        visited[r][c][0] = false;
        
        // 지울 기둥 위에 있는 보가 있고 지금 지우면 안됨 - 왼쪽
        if ((r + 1 <= n && c - 1 >= 0) && visited[r + 1][c - 1][1] && !canInstallVo(n, r + 1, c -1, visited)) {
            visited[r][c][0] = true;
            return false;
        }
        
        // 지울 기둥 위에 있는 보가 있고 지금 지우면 안됨 - 왼쪽
        if ((r + 1 <= n) && visited[r + 1][c][1] && !canInstallVo(n, r + 1, c, visited)) {
            visited[r][c][0] = true;
            return false;
        }
        
        // 지울 기둥 위에 있는 기둥 있고 지금 지우면 안됨 - 왼쪽
        if ((r + 1 <= n && c >= 0) && visited[r + 1][c][0] && !canInstallKidoong(n, r + 1, c, visited)) {
            visited[r][c][0] = true;
            return false;
        }
        
        return true;
    }
        
    public boolean canInstallKidoong(int n, int r, int c, boolean[][][] visited) {
        // - 바닥 위
        if (r == 0) return true;
        
        // - 보의 한쪽 끝부분 위
        if ((c - 1 >= 0 && visited[r][c - 1][1]) || visited[r][c][1]) return true;
            
        // - 다른 기둥 위
        if (visited[r - 1][c][0]) return true;
        
        return false;
    }
        
    public boolean canDeleteVo(int n, int r, int c, boolean[][][] visited) {
        // 이미 없으면 못지움
        if (!visited[r][c][1]) return false;
        
        // 이거 지웠을 때 영향 가는 애들 다 통과이면 삭제 가능
        visited[r][c][1] = false;
        
        // 양쪽에 보가 있고 지금 지우면 안됨 - 왼쪽
        if ((c - 1 >= 0) && visited[r][c - 1][1] && !canInstallVo(n, r, c - 1, visited)) {
            visited[r][c][1] = true;
            return false;
        }
        
        // 양쪽에 보가 있고 지금 지우면 안됨 - 오른쪽
        if ((c + 1 <= n) && visited[r][c + 1][1] && !canInstallVo(n, r, c + 1, visited)) {
            visited[r][c][1] = true;
            return false;
        }
        
        // 내 위에 있는 기둥이 있고 지금 지우면 안됨 - 왼쪽
        if (visited[r][c][0] && !canInstallKidoong(n, r, c, visited)) {
            visited[r][c][1] = true;
            return false;
        }
        
        // 내 위에 있는 기둥이 있고 지금 지우면 안됨 - 오른쪽
        if ((c + 1 <= n) && visited[r][c + 1][0] && !canInstallKidoong(n, r, c + 1, visited)) {
            visited[r][c][1] = true;
            return false;
        }
        
        return true;
    }
        
    public boolean canInstallVo(int n, int r, int c, boolean[][][] visited) {
        // - 한쪽 끝부분이 기둥의 위
        if ((r - 1 >= 0 && visited[r - 1][c][0]) ||
            (r - 1 >= 0 && c + 1 <= n && visited[r - 1][c + 1][0])) return true;

        // - 양쪽 끝이 다른 보와 동시에 연결
        if (c - 1 >= 0 && c + 1 <= n && visited[r][c - 1][1] && visited[r][c + 1][1]) return true;
        return false;
    }
}
