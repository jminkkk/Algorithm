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

    private boolean isValidBST(TreeNode now, long min, long max) {
        // null인 경우
        if (now == null) return true;

        // 값 검증
        if (now.val <= min || now.val >= max) return false;

        return isValidBST(now.left, min, Math.min(max, now.val)) 
            && isValidBST(now.right, Math.max(min, now.val), max);
    }
}
