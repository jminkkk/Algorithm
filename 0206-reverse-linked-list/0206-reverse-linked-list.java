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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = null;
        ListNode now = head;

        while (now.next != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }

        now.next = pre;
        return now;
    }
}