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
    private boolean status;
    public boolean isBalanced(TreeNode root) {
        status = true;
        getHeight(root);
        return status;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left_height = getHeight(root.left);
        int right_height = getHeight(root.right);
        
        if (Math.abs(left_height - right_height) > 1)
            status = false;

        return Math.max(left_height, right_height) + 1;
    }
}
