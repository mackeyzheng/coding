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
    private int max_sum;
    public int maxPathSum(TreeNode root) {
       max_sum = Integer.MIN_VALUE;
       dfs(root);
       return max_sum;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left_sum = dfs(root.left);
        int right_sum = dfs(root.right);

        int sum = root.val; // current sum must have root.val
        if (left_sum > 0)
            sum += left_sum;
        if (right_sum > 0)
            sum += right_sum;

        max_sum = Math.max(max_sum, sum);
        return Math.max(root.val, root.val + Math.max(left_sum, right_sum));
    }
}
