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
        max = 0;
        dfs(root);
        return max;
    }

    private int max;
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left == null || root.val + 1 != root.left.val) left = 0;
        if (root.right == null || root.val + 1 != root.right.val) right = 0;
        int sum = Math.max(left, right) + 1;
        max = Math.max(max, sum);
        return sum;
    }
}
