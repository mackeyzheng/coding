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
    // solution2: inorder traversal using Morris algorithm
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


    // solution1: inorder recursively
    public void recoverTree(TreeNode root) {
        TreeNode[] cache = new TreeNode[2];
        traverse(root, cache);
        if (cache[1] != null) {
            // swap
            int tmp = cache[0].val;
            cache[0].val = cache[1].val;
            cache[1].val = tmp;
        }
    }

    private TreeNode prev = null;

    // cannot put prev to traverse method signature, only copy of its reference is passed
    private void traverse(TreeNode node, TreeNode[] cache) {
        if (node == null) {
            return;
        }

        traverse(node.left, cache);

        if (prev != null) {
            if (prev.val > node.val) {
                if (cache[0] == null) {
                    cache[0] = prev;
                }
                cache[1] = node;
            }
        }

        prev = node;

        traverse(node.right, cache);
    }
}
