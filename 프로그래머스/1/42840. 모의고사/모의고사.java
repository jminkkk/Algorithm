import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] student = {
            {1, 2, 3, 4, 5}, 
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} 
        };
        
        int[] answer = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == student[j][i % student[j].length]) answer[j]++;
            }
        }
        
        int max = Arrays.stream(answer).max().getAsInt();

        return IntStream.range(0, 3)
            .filter(i -> answer[i] == max)
            .map(i -> i + 1)
            .toArray();
    }
}