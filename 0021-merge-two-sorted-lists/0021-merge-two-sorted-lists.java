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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // head 찾기
        ListNode head = null;
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head = list1;
                list1 = list1.next;
            } else {
                head = list2;
                list2 = list2.next;
            }
        } else if (list1 != null) {
            head = list1;
            list1 = list1.next;
        } else if (list2 != null) {
            head = list2;
            list2 = list2.next;
        }

        ListNode now = head;
        // 두 리스트의 값을 비교하면서 병합
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                now.next = list1;
                now = list1;
                list1 = list1.next;
            } else {
                now.next = list2;
                now = list2;
                list2 = list2.next;
            }
        }
        
        // list1은 안끝난 경우 끝까지 연결
        while (list1 != null) {
            now.next = list1;
            now = list1;
            list1 = list1.next;
        }

        // list2은 안끝난 경우 끝까지 연결
        while (list2 != null) {
            now.next = list2;
            now = list2;
            list2 = list2.next;
        }

        return head;
    }
}