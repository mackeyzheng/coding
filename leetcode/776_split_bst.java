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
    public TreeNode[] splitBST(TreeNode root, int V) {
        // base case
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        // root and root.left
        if (root.val <= V) {
            TreeNode[] nodes = splitBST(root.right, V);
            root.right = nodes[0];
            return new TreeNode[]{root, nodes[1]};
        }

        // root.right
        TreeNode[] nodes = splitBST(root.left, V);
        root.left = nodes[1];
        return new TreeNode[]{nodes[0], root};
    }
}
