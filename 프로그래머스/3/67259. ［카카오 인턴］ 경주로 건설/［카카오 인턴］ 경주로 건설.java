import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int n = board.length;
        
        int[][][] dist = new int[n][n][4];
        for (int[][] plane : dist)
            for (int[] row : plane)
                Arrays.fill(row, Integer.MAX_VALUE);        
        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) dist[0][0][i] = 0;
        q.add(new Node(0, 0, 0, 0));
        q.add(new Node(0, 0, 1, 0));
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (dist[now.x][now.y][now.dir] < now.v) continue;
            dist[now.x][now.y][now.dir] = now.v;
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (canNotGo(nx, ny, board)) continue;
                int cost = now.dir == i ? 100 : 600;

                q.add(new Node(nx, ny, i, dist[now.x][now.y][now.dir] + cost));
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) answer = Math.min(answer, dist[n - 1][n - 1][i]);
        return answer;
    }
    
    public boolean canNotGo(int x, int y, int[][] board) {
        return x < 0 || y < 0 || x >= board.length || y >= board.length || board[x][y] == 1 ;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int dir;
    int v;
    
    Node(int x, int y, int dir, int v) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.v = v;
    }
    
    public int compareTo(Node o) {
        return Integer.compare(this.v, o.v);
    }
}

// 경주로 건설
// N * N 격자 / 벽 존재 / 상하좌우 이동 / 방향이 90도 전환되는 경우
// 도착지까지의 비용 최소화 -> 가중치가 있을 때 한정점에서 다른 정점까지 비용이 최소값인 경로
// 비용 결정 방식
    // 1. 직전 방향과 같은 방향으로 이동 -> +100
    // 2. 이전 방향에서 90도 전환한 방향으로 이동 -> +600
// 다익스트라, 플로이드 워셜
// 다익스트라 -> 큐를 사용하고 주어진 간선들을 거의 대부분 순회하기 때문에 O(E * logV)
// 플로이드워셜 

// int[] dist = new int[n + 1];
// Queue<Node> q = new LinkedList<>();
// q.add(시작);
// while (!q.isEmpty()) {
//     Node now = q.poll();
//     dist[now.nd] = now.v;
//     for (int[] next: graph[now.nd]) {
//         int nextNd = next[0];
//         int nextV = next[1];
//         if (dist[nextNd] < dist[now.nd] + nextV) continue;
        
//         q.add(new(nextNd, dist[now.nd] + nextV))
//     }
// }

// node {
//     int nd;
//     int totalV
// }

// 다익스트라 알고리즘의 구현은 
// 큐와 배열을 사용해서, 연결된 엣지를 순회하며 경로들의 최소 비용을 갱신하는 알고리즘 