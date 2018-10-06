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
    // build top-down, recursive
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode left = upsideDownBinaryTree(root.left);
        TreeNode node = root.left;
        node.left = root.right;
        node.right = root;
        // reset root's children
        root.left = null;
        root.right = null;
        return left;
    }

    // build bottom-up, time: O(n), space: O(1)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parent = null;
        TreeNode parentRight = null;
        while (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = parentRight;
            root.right = parent;
            parent = root;
            parentRight = right;
            root = left;
        }
        return parent;
    }

    // time: O(n), space: O(n)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode ret = root;
        while (ret.left != null) {
            stack.push(ret);
            ret = ret.left;
        }

        TreeNode cur = ret;

        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            parent.left = null;
            cur.left = parent.right;
            parent.right = null;
            cur.right = parent;
            cur = cur.right;
        }

        return ret;
    }
}
