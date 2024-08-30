import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {        
        int[] counts = new int[N + 1];
        for (int i = 0; i < stages.length; i++) {
            counts[stages[i] - 1]++;
        }
        
        Map<Integer, Float> map = new HashMap<>();
        int total = stages.length;
        for (int i = 0; i < N; i++) {
            map.put(i + 1, total != 0 ? counts[i] / (float) total : 0);
            total -= counts[i];
        }

        return map.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey)
            .toArray();
    }
}