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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null && cur.val != p.val) {
            if (cur.val < p.val) {
                cur = cur.right;
            } else {
                prev = cur;
                cur = cur.left;
            }
        }
        // not found
        if (cur == null) {
            return null;
        }

        // p node has right subtree
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }

        // p node has no right subtree
        return prev;
    }

    // clean version
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                // root.val <= p.val
                root = root.right;
            }
        }
        return res;
    }
}
