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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        // 현재 값보다 삽입하려는 값이 크면 오른쪽에 삽입
        if (root.val < val) {
            if (root.right == null) root.right = new TreeNode(val);
            else root.right = insertIntoBST(root.right, val);
        }

        // 현재 값보다 삽입하려는 값이 작으면 왼쪽에 삽입
        if (root.val > val) {
            if (root.left == null) root.left = new TreeNode(val);
            else root.left = insertIntoBST(root.left, val);
        }
        
        return root;
    }
}