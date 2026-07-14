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
    public ListNode middleNode(ListNode head) {
        // 전체 노드의 길이 확인
        ListNode now = head;
        int cnt = 1;
        while (now.next != null) {
            now = now.next;
            cnt++;
        }

        // 순회하면서 중간 노드인 경우 반환
        int mid = cnt / 2;
        now = head;
        for (int i = 0; i < mid; i++) {
            now = now.next;
        }

        return now;
    }
}