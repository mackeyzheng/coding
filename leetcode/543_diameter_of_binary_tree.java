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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ret = new int[1];
        dfs(root, ret);
        return ret[0];
    }

    private int dfs(TreeNode node, int[] ret) {
        if (node == null)
            return 0;
        int left = dfs(node.left, ret);
        int right = dfs(node.right, ret);
        ret[0] = Math.max(ret[0], left + right);
        return 1 + Math.max(left, right);
    }
}
