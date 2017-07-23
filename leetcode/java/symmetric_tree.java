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
    // iteratively
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.right);
        stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left != null && right != null) {
                if (left.val != right.val) return false;
                stack.push(right.left);
                stack.push(left.right);
                stack.push(right.right);
                stack.push(left.left);
            } else if (!(left == null && right == null)) {
                return false;
            }
        }
        return true;
    }

    // recursively
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == null && b == null;
        if (a.val != b.val) return false;
        return helper(a.left, b.right) && helper(a.right, b.left);
    }
}
