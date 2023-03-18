import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    static int danziCount = 0; // 단지 수
    static List<Integer> houseCount = new ArrayList<>(); // 단지에 속하는 집의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 지도의 크기
        int map[][] = new int[N][N];
        int visited[][] = new int[N][N]; // 방문처리

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    count = 1; //현재 위치의 집 포함
                    houseCount.add(DFS(i, j, map, visited));
                    danziCount++;
                }
            }
        }

        if (danziCount == 0) System.out.println(0);
        else {
            Collections.sort(houseCount);

            System.out.println(danziCount); // 단지 수 출력
            for (Integer i : houseCount) {
                System.out.println(i); // 단지에 속하는 집의 수 출력
            }
        }

    }

    public static int DFS(int x, int y, int map[][], int visited[][]) {
        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValidNum(nextX, nextY, map) && map[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                DFS(nextX, nextY, map, visited);
                count++;
            }
        }

        return count;
    }

    private static boolean isValidNum(int x, int y, int[][] map) {
        return (x >= 0 && x < map.length && y >= 0 && y < map.length);
    }
}