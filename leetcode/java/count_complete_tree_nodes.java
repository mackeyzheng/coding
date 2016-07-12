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
    // O((lgn)^2)
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int hl = 0;
        int hr = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null) {
            hl++;
            left = left.left;
        }

        while (right != null) {
            hr++;
            right = right.right;
        }

        if (hl == hr)
            return (1 << hl) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

//    // iterative: O((lgn)^2)
//    public int countNodes(TreeNode root) {
//        int num = 0;
//        int h = height(root);
//        while (root != null) {
//            if (height(root.right) == h - 1) {
//                num += 1 << h;
//                root = root.right;
//            } else {
//                num += 1 << (h - 1);
//                root = root.left;
//            }
//            h--;
//        }
//        return num;
//    }
//
//    private int height(TreeNode root) {
//        return root == null ? -1 : 1 + height(root.left); // height of leaf node is 0
//    }

//    // recursive: O((lgn)^2)
//    public int countNodes(TreeNode root) {
//        int h = height(root);
//        // one level below leaf node
//        if (h == -1)
//            return 0;
//        // height of left subtree is the same as right subtree, incomplete leaf part is on the right side
//        // no. of nodes of a full complete tree is 2^(h+1) - 1
//        else if (height(root.right) == h - 1)
//            return (1 << h) + countNodes(root.right);
//        // right subtree has smaller height than left subtree, incomplete leaf part is on the left side
//        else
//            return (1 << (h - 1)) + countNodes(root.left);
//    }
//
//    private int height(TreeNode root) {
//        return root == null ? -1 : 1 + height(root.left); // height of leaf node is 0
//    }
}
