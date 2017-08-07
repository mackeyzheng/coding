/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ret;
    }

    private boolean ret = true;
    private int dfs(TreeNode node) {
        if (!ret || node == null) return -1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (Math.abs(left - right) > 1) {
            ret = false;
        }
        return 1 + Math.max(left, right);
    }
}
