/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p,q가 왼오로 나뉘어지는 노드가 있는지 확인
        int min = Math.min(p.val, q.val);
        int max = Math.max(q.val, p.val);

        // 현재 노드 기준으로 p,q 모두가 쪼개지는 경우 현재 노드를 즉시 반환
        if (root.val >= min && root.val <= max) return root;

        // 현재 노드 기준으로 p,q 모두가 같은 왼쪽 또는 같은 오른쪽인 경우 하위트리 탐색
        if (root.val > min) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}