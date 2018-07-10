/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class Solution {
    // inorder traversal using Morris algorithm
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null; // previous node on the inorder traversal path
        TreeNode[] cache = new TreeNode[2];
        
        // inorder traverse the tree: should be a non-decreasing array
        while (cur != null) {
            if (cur.left == null) {
                detect(prev, cur, cache);
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) {
                    node.right = cur;
                    cur = cur.left;
                } else {
                    node.right = null;
                    detect(prev, cur, cache);
                    prev = cur;
                    cur = cur.right;
                }
            }
        }

        // swap
        int tmp = cache[0].val;
        cache[0].val = cache[1].val;
        cache[1].val = tmp;
    }

    private void detect(TreeNode prev, TreeNode cur, TreeNode[] cache) {
        if (prev != null && prev.val > cur.val) {
            if (cache[0] == null) {
                cache[0] = prev;
            } // notice here, do not use else, in case that {0, 1}, then cache[1] will not be initialized
            cache[1] = cur;
        }
    }
}
