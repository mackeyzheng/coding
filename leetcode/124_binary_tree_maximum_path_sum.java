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
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int max = Integer.MIN_VALUE;

    private int maxSum(TreeNode node) {
        if (node == null) return 0;
        int leftSum = maxSum(node.left);
        int rightSum = maxSum(node.right);
        // max local sum ending at current node
        int localSum = Math.max(node.val, Math.max(leftSum, rightSum) + node.val);
        max = Math.max(max, Math.max(localSum, leftSum + rightSum + node.val));
        return localSum;
    }
}
