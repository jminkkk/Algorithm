/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode now = head;
        int len = 0;
        while (now != null) {
            now = now.next;
            len++;
        }
        
        if (len == n) {
            return head.next;
        }

        // 앞에서 len - n 번째 노드
        ListNode dummy = new ListNode(0, head);
        now = dummy;
        for (int i = 0; i < len - n; i++) {
            now = now.next;
        }
        
        now.next = now.next.next;
        return head;
    }
}