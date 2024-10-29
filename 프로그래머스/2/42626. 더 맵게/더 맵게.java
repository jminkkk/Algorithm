import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : scoville) {
            priorityQueue.add(i);
        }

        int count = 0;

        while (priorityQueue.size() > 1 && priorityQueue.peek() < K) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();

            int newScoville = a + (b * 2);
            priorityQueue.add(newScoville);
            count++;
        }

        if (priorityQueue.peek() < K) {
            return -1;
        }

        return count;
    }
}
