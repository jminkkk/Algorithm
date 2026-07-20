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
// 사이클이 시작되는 노드 알아내기
 // slow는 모두 순회
 // fast는 건너뛰며 순회
 // slow가 두번 나오는 노드가 시작노드
// 엣지케이스: slow가 한바퀴 돌지 않은 시점에서 끝날 수도 있다
// 충분히 한바뀌는 돌아야 함 -> 어케 보장? -> 공배수?............... -> 
// fast도 2번 나오게 되면 길이는 알 수 잇음 -> slow 두번나오는 거 확인

// slow 0 1 2 3 1 2 3
// fast 0 2 1 3 2 1 3

// slow 0 1 0 1
// fast 0 1 1 1 1
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!seen.add(cur)) return cur;  // 이미 있으면 add가 false → 첫 재방문 = 시작점
            cur = cur.next;
        }
        return null;
    }
}
