// import java.util.*;

// class Solution {
    
//     int HORIZONTAL = 0;
//     int VERTICAL = 1;
//     int[][] dx = {{HORIZONTAL, 1}, {VERTICAL, 0}}; // dir  dy
//     int[][] dy = {{HORIZONTAL, 0}, {VERTICAL, 1}}; // dir  dy
                  
//     public int solution(int[][] board) {
//         int answer = 0;
        
//         int mapLen = board.length;
//         boolean[][][] visited = new boolean[mapLen][mapLen][2];
        
//         Queue<Node> q = new LinkedList<>();
//         q.add(new Node(0, 0, 0));
        
//         int cnt = 0;
//         while (!q.isEmpty())  {
//             int size = q.size();
            
//             for (int i = 0; i < size; i++) {
//                 // 1. now 도착했는지 확인
//                 Node now = q.poll();
//                 System.out.println(now.x + " " + now.y);
//                 visited[now.x][now.y][now.dir] = true;
//                 if (now.isReached(mapLen)) return cnt;
                
//                 // 2. next 이동 가능한지
//                 // 2-1. 직진 -> 이동 공간 체크 필요
//                 int nx = now.x + dx[now.dir][1];
//                 int ny = now.y + dy[now.dir][1];
//                 if (canMoveStraight(nx, ny, now.dir, board, visited)) {
//                     q.add(new Node(nx, ny, now.dir));
//                     // visited[nx][ny][now.dir] = true;                    
//                 }
                

//                 // 2-2. 90도 회전
//                 // x, y는 그대로지만 방향 변경 가능한지 -> 사각형 체크 필요
//                 int ndir = Math.abs(now.dir - 1);
//                 if (canMove90(now.x, now.y, ndir, board, visited)) {
//                     q.add(new Node(now.x, now.y, ndir));
//                     // visited[now.x][now.y][ndir] = true;                    
//                 }
//             }
//             cnt++;
//         }
        
//         return cnt;
//     }
    
//     private boolean canMoveStraight(int x, int y, int dir, int[][] board, boolean[][][] visited) {
//         if (visited[x][y][dir]) return false;
        
//         int nx = x + dx[dir][0];
//         int ny = y + dy[dir][1];
        
//         return nx < board.length && ny < board.length && board[nx][ny] == 0;
//     }
    
//     private boolean canMove90(int x, int y, int ndir, int[][] board, boolean[][][] visited) {
//         // 이미 방문했었는지 확인
//         if (visited[x][y][ndir]) return false;

//         // 사각형 확인
//         int[][] dArr = {{0, 1}, {1, 0}, {1, 1}};
//         for (int i = 0; i < 3; i++) {
//             int nx = x + dArr[i][0];
//             int ny = y + dArr[i][1];
            
//             if (nx >= board.length || ny >= board.length || board[nx][ny] == 1) return false;
//         }
        
//         return true;
//     }
// }

// class Node {
//     int x;
//     int y;
//     int dir;
    
//     Node(int x, int y, int dir) {
//         this.x = x;
//         this.y = y;
//         this.dir = dir;
//     }
    
//     public boolean isReached(int mapLen) {
//         return (dir == 0 && x == mapLen - 1 && y == mapLen - 2)
//             || (dir == 1 && x == mapLen - 2 && y == mapLen - 1);
//     }
// }



import java.util.*;

class Solution {

    int HORIZONTAL = 0;
    int VERTICAL = 1;

    // ⭐ 변경 1: 로봇의 방향과 "이동 방향"을 분리
    // 상, 하, 좌, 우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int mapLen = board.length;

        boolean[][][] visited = new boolean[mapLen][mapLen][2];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, HORIZONTAL));
        visited[0][0][HORIZONTAL] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node now = q.poll();

                // 1. 도착했는지 확인
                if (now.isReached(mapLen)) {
                    return cnt;
                }

                // =====================================================
                // 2-1. 평행 이동
                // =====================================================

                for (int d = 0; d < 4; d++) {

                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (canMoveStraight(
                            nx,
                            ny,
                            now.dir,
                            board,
                            visited
                    )) {
                        visited[nx][ny][now.dir] = true;
                        q.add(new Node(nx, ny, now.dir));
                    }
                }


                // =====================================================
                // 2-2. 90도 회전
                // =====================================================

                rotate(now, board, visited, q);
            }

            cnt++;
        }

        return -1;
    }


    // ============================================================
    // 평행 이동
    // ============================================================

    private boolean canMoveStraight(
        int x,
        int y,
        int dir,
        int[][] board,
        boolean[][][] visited
    ) {

        int n = board.length;

        // 위/왼쪽 이동도 가능하므로 음수 범위 확인 필요
        if (x < 0 || y < 0 ||
            x >= n || y >= n) {
            return false;
        }

        if (visited[x][y][dir]) {
            return false;
        }

        int x2 = x;
        int y2 = y;

        if (dir == HORIZONTAL)  y2++;
        else x2++;

        // 두 번째 칸 범위 검사
        if (x2 < 0 || y2 < 0 ||
            x2 >= n || y2 >= n) {
            return false;
        }

        // 이동 후 로봇의 두 칸이 모두 빈칸이어야 함
        return board[x][y] == 0
            && board[x2][y2] == 0;
    }


    // ============================================================
    // 회전
    // ============================================================
    private void rotate(
        Node now,
        int[][] board,
        boolean[][][] visited,
        Queue<Node> q
    ) {

        int n = board.length;

        int x = now.x;
        int y = now.y;


        // ========================================================
        // 가로 → 세로
        // ========================================================

        if (now.dir == HORIZONTAL) {
            if (x + 1 < n &&
                board[x + 1][y] == 0 &&
                board[x + 1][y + 1] == 0) {

                // A를 축으로 회전
                if (!visited[x][y][VERTICAL]) {

                    visited[x][y][VERTICAL] = true;
                    q.add(new Node(
                        x,
                        y,
                        VERTICAL
                    ));
                }

                // B를 축으로 회전
                if (!visited[x][y + 1][VERTICAL]) {

                    visited[x][y + 1][VERTICAL] = true;
                    q.add(new Node(
                        x,
                        y + 1,
                        VERTICAL
                    ));
                }
            }


            /*
             * 위쪽 회전
             *
             * □ □
             * A B
             */

            if (x - 1 >= 0 &&
                board[x - 1][y] == 0 &&
                board[x - 1][y + 1] == 0) {

                // A를 축으로 회전
                if (!visited[x - 1][y][VERTICAL]) {

                    visited[x - 1][y][VERTICAL] = true;
                    q.add(new Node(
                        x - 1,
                        y,
                        VERTICAL
                    ));
                }

                // B를 축으로 회전
                if (!visited[x - 1][y + 1][VERTICAL]) {

                    visited[x - 1][y + 1][VERTICAL] = true;
                    q.add(new Node(
                        x - 1,
                        y + 1,
                        VERTICAL
                    ));
                }
            }
        }


        // ========================================================
        // 세로 → 가로
        // ========================================================

        else {
            if (y + 1 < n &&
                board[x][y + 1] == 0 &&
                board[x + 1][y + 1] == 0) {

                // A를 축으로 회전
                if (!visited[x][y][HORIZONTAL]) {
                    visited[x][y][HORIZONTAL] = true;
                    q.add(new Node(x, y, HORIZONTAL));
                }

                // B를 축으로 회전
                if (!visited[x + 1][y][HORIZONTAL]) {
                    visited[x + 1][y][HORIZONTAL] = true;
                    q.add(new Node(x + 1, y,HORIZONTAL));
                }
            }


            if (y - 1 >= 0 &&
                board[x][y - 1] == 0 &&
                board[x + 1][y - 1] == 0) {

                // A를 축으로 회전
                if (!visited[x][y - 1][HORIZONTAL]) {
                    visited[x][y - 1][HORIZONTAL] = true;
                    q.add(new Node(x, y - 1, HORIZONTAL));
                }

                // B를 축으로 회전
                if (!visited[x + 1][y - 1][HORIZONTAL]) {
                    visited[x + 1][y - 1][HORIZONTAL] = true;
                    q.add(new Node(x + 1, y - 1, HORIZONTAL));
                }
            }
        }
    }
}


class Node {

    int x;
    int y;
    int dir;

    Node(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public boolean isReached(int mapLen) {
        return (dir == 0 && x == mapLen - 1 && y == mapLen - 2)
            || (dir == 1 && x == mapLen - 2 && y == mapLen - 1);
    }
}