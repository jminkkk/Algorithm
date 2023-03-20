import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int n = 0; n < commands.length; n++) {
            int arr[] = Arrays.copyOfRange(array, commands[n][0] - 1, commands[n][1]);
            Arrays.sort(arr);
            
            answer[n] = arr[commands[n][2] - 1];
        }
        
        return answer;
    }
}