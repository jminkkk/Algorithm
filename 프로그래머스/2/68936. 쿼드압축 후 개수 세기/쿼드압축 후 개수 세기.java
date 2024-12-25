class Solution {
    static int[] answer;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    
    public int[] solution(int[][] arr) {
        answer = new int[]{0, 0};
        zip(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void zip(int[][] arr, int x, int y, int depth) {
        if (canZip(arr, x, y, depth)) {
            answer[arr[x][y]]++;
            return;
        }

        int half = depth / 2;
        zip(arr, x, y, half);
        zip(arr, x + half, y, half);
        zip(arr, x, y + half, half);
        zip(arr, x + half, y + half, half);
    }
    
    public boolean canZip(int[][] arr, int x, int y, int depth) {
        for (int i = x; i < x + depth; i++) {
            for (int j = y; j < y + depth; j++) {
                if (arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }
}