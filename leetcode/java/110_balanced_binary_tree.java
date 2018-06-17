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
    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }

    private boolean balanced = true;;
    private int height(TreeNode node) {
        if (!balanced || node == null) return -1;
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) > 1) {
            balanced = false;
        }
        return 1 + Math.max(left, right);
    }
}
