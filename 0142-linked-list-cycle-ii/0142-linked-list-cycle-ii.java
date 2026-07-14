/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    Set<ListNode> set = new HashSet<>();

    public ListNode detectCycle(ListNode head) {
        ListNode now = head;
        
        while (true) {
            if (now == null) return null;
            if (set.contains(now)) return now;

            set.add(now);
            now = now.next;            
        }
        
        // 사이클 있는 경우
            // 

        // 사이클 없는 경우
            // 다음 노드가 null인 경우
    }
}