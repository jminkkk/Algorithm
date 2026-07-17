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
    // Map<Integer, ListNode> map = new HashMap<>();
    Set<ListNode> set = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        ListNode now = head;
        int idx = 0;
        while (!set.contains(now)) {
            if (now == null) return false;
            set.add(now);
            now = now.next;
        }

        return true;
    }
}