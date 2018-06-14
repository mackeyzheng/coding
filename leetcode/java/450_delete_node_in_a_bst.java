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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dh = new TreeNode(0);
        dh.left = root;
        TreeNode cur = root;
        TreeNode prev = dh;
        while (cur != null && cur.val != key) {
            prev = cur;
            if (cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        // not found
        if (cur == null) return root;

        // no right subtree
        if (cur.right == null) {
            if (prev.left == cur) {
                prev.left = cur.left;
            } else {
                prev.right = cur.left;
            }
            cur.left = null;
            return dh.left;
        }

        // find successor
        TreeNode suc = cur.right;
        prev = cur;
        while (suc.left != null) {
            prev = suc;
            suc = suc.left;
        }

        // move
        cur.val = suc.val;
        cur.right = deleteNode(cur.right, cur.val);
        return dh.left;
    }

    // clean version
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // key == root.val
            // delete current root node
            if (root.left == null) {
                // replace root with root.right
                return root.right;
            } else if (root.right == null) {
                // replace root with root.left
                return root.left;
            }
            TreeNode node = findSuccessor(root);
            root.val = node.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode node) {
        if (node == null || node.right == null) return null;
        TreeNode p = node.right;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
}
