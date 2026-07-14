/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        // 검증하려는 노드가 null true
        if (node == null) return true;

        // 현재 값 검증
        if (node.val < min || node.val > max) return false;

        // 자식 노드 검증
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}