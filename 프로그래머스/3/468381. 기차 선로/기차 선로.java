class Solution {

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int DOWN = 2;
    private static final int UP = 3;

    private final int[] dy = {0, 0, 1, -1};
    private final int[] dx = {1, -1, 0, 0};

    // 현재 방향에서 놓을 수 있는 선로
    private final int[][] placeable = {
            {1, 3, 4, 7},
            {1, 3, 5, 6},
            {2, 3, 4, 5},
            {2, 3, 6, 7}
    };

    // valid[rail][direction]
    private final boolean[][] valid = {
            {},
            {true,  true,  false, false}, // 1
            {false, false, true,  true }, // 2
            {true,  true,  true,  true }, // 3
            {true,  false, true,  false}, // 4
            {false, true,  true,  false}, // 5
            {false, true,  false, true }, // 6
            {true,  false, false, true }  // 7
    };

    private int[][] grid;
    private int[][] visited;
    private int n, m;
    private int answer;

    public int solution(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        visited = new int[n][m];
        visited[0][0] = 1;
        visited[n - 1][m - 1] = 1;

        dfs(0, 1, RIGHT);

        return answer;
    }

    private void dfs(int y, int x, int dir) {
        if (y < 0 || y >= n || x < 0 || x >= m) return;
        if (grid[y][x] == -1) return;

        if (y == n - 1 && x == m - 1) {
            if (isValidRail(grid[y][x], dir) && visitedAllRails()) {
                answer++;
            }
            return;
        }

        visited[y][x]++;

        if (grid[y][x] == 0) {
            for (int rail : placeable[dir]) {
                grid[y][x] = rail;

                int nd = nextDirection(rail, dir);
                dfs(y + dy[nd], x + dx[nd], nd);

                grid[y][x] = 0;
            }
        } else if (isValidRail(grid[y][x], dir)) {
            int nd = nextDirection(grid[y][x], dir);
            dfs(y + dy[nd], x + dx[nd], nd);
        }

        visited[y][x]--;
    }

    private boolean isValidRail(int rail, int dir) {
        return rail >= 1 && rail <= 7 && valid[rail][dir];
    }

    private int nextDirection(int rail, int dir) {
        switch (rail) {
            case 4:
                return dir == DOWN ? LEFT : UP;
            case 5:
                return dir == DOWN ? RIGHT : UP;
            case 6:
                return dir == UP ? RIGHT : DOWN;
            case 7:
                return dir == UP ? LEFT : DOWN;
            default:
                return dir;
        }
    }

    private boolean visitedAllRails() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                int rail = grid[y][x];

                if (rail < 1 || rail > 7) continue;

                if (rail == 3) {
                    if (visited[y][x] != 2) return false;
                } else if (visited[y][x] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}