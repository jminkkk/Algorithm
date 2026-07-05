import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int numCnt = 0;
        int operCnt = 0;
        int reverseOperCnt = 0;
        
        List<Integer> nums = new ArrayList<>();
        
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        for (String now: operations) {
            if (now.equals("D -1")) {
                if (!asc.isEmpty()) {
                    int removeNum = asc.poll();
                    nums.remove((Integer) removeNum);
                    operCnt++;
                }
                
                numCnt = numCnt > 0 ? numCnt - 1 : 0;
            } else if (now.equals("D 1")) {
                if (!desc.isEmpty()) {
                    int removeNum = desc.poll();
                    nums.remove((Integer) removeNum);
                    reverseOperCnt++;
                }
                
                numCnt = numCnt > 0 ? numCnt - 1 : 0;
            } else {                
                int num = Integer.parseInt(now.split("I ")[1]);
                asc.add(num);
                desc.add(num);
                nums.add(num);
                numCnt++;
            }
        }
        
        if (numCnt == 0) return new int[]{0, 0};
        if (numCnt == 1) {
            if (reverseOperCnt > operCnt) {       
                int num = desc.poll();
                return new int[]{num, num};
            } else {
                int num = asc.poll();
                return new int[]{num, num};
            }
        }
        

        int min = 0; 
        while (!asc.isEmpty()) {
            int num = asc.poll();
            if (!nums.contains(num)) continue;
            min = num;
            break;
        } 
        
        int max = 0; 
        while (!desc.isEmpty()) {
            int num = desc.poll();
            if (!nums.contains(num)) continue;
            max = num;
            break;
        } 
        return new int[]{max, min};
    }
}

// ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]
// ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]

// 내림차 333 / 97 / 45 / -45 / -642 
// 오름차 -45 / 45 / 653 / 97 / 333

// ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]

// 내림차 -5643
// 오름차 16