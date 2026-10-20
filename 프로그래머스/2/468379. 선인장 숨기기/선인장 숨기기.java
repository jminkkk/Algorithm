import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        
        int[][] map = new int[m][n];
        int INF = 500_001;
        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], INF);
        }

        // 1. 비에 맞는 구간 순서을 지도에 저장
        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            map[r][c] = i + 1;
        }
        
        // 2. 선인장 범위에 대해 모노노틱 덱으로 구간별로 가장 빠른 순서를 체크
            // 모노노틱 덱 -> 슬라이딩 윈도우로 구간의 최솟값을 구하는 방식
            // 1. 구간 이동 시 범위 벗어나는 인덱스 제거
            // 2. 신규 들어오는 값보다 큰 애들은 deque에서 제거 -> 즉 first 요소는 최솟값이 됨
        int[][] newMap = new int[m][n];
        for (int r = 0; r < m; r++) {
            Deque<Integer> dq = new LinkedList<>();
    
            int start = 0;
            int end = 0;
            
            // 초기 설정
            while (end < start + w) {
                while (!dq.isEmpty() && map[r][dq.peekLast()] >= map[r][end]) {
                    dq.removeLast();
                }
                
                dq.offer(end++);
            }
            
            // 구간 이동
            while (start <= n - w) {
                newMap[r][start++] = map[r][dq.peekFirst()];
                if (end == n) break;
                
                while (!dq.isEmpty() && dq.peekFirst() < start) dq.removeFirst();

                while (!dq.isEmpty() && map[r][dq.peekLast()] >= map[r][end]) {
                    dq.removeLast();
                }
                dq.offer(end++);
            }
        }

        int[][] finalMap = new int[m - h + 1][n - w + 1];
        for (int c = 0; c <= n - w; c++) {
            Deque<Integer> dq = new LinkedList<>();
    
            int start = 0;
            int end = 0;
            
            // 초기 설정
            while (end < start + h) {
                while (!dq.isEmpty() && newMap[dq.peekLast()][c] >= newMap[end][c]) {
                    dq.removeLast();
                }
                
                dq.offer(end++);
            }
            
            // 구간 이동
            while (start <= m - h) {
                finalMap[start++][c] = newMap[dq.peekFirst()][c];
                if (end == m) break;
                
                while (!dq.isEmpty() && dq.peekFirst() < start) dq.removeFirst();

                while (!dq.isEmpty() && newMap[dq.peekLast()][c] >= newMap[end][c]) {
                    dq.removeLast();
                }
                dq.offer(end++);
            }
        }
        
        // 3. 가장 순서가 큰 구간이 answer
        int max = finalMap[0][0]; 
        int answerR = 0;
        int answerC = 0;
        for (int r = 0; r <= m - h; r++) {
            for (int c = 0; c <= n - w; c++) {
                // System.out.println(r + " " + c + " " + newMap[r][c]);
                if (max >= finalMap[r][c]) continue;
                
                answerR = r;
                answerC = c;
                max = finalMap[r][c];
                
                // System.out.print(finalMap[r][c] + " ");
            }

            // System.out.println("");
        }
        
        int[] answer = new int[]{answerR, answerC};
        return answer;
    }
}