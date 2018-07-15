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
    public int longestConsecutive(TreeNode root) {
        int[] ret = new int[]{0};
        dfs(root, Integer.MIN_VALUE, ret);
        return ret[0];
    }

    private int dfs(TreeNode node, int parent, int[] ret) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, node.val, ret);
        int right = dfs(node.right, node.val, ret);
        int len = 1;
        if (node.left != null && node.val + 1 == node.left.val) {
            len += left;
        }
        if (node.right != null && node.val + 1 == node.right.val) {
            len = Math.max(len, 1 + right);
        }
        ret[0] = Math.max(ret[0], Math.max(Math.max(left, right), len));
        return len;
    }
}
