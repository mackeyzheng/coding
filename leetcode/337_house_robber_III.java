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
    // tree DP - use postorder to transform status
    public int rob(TreeNode root) {
        Node node = traverse(root);
        return Math.max(node.rob, node.skip);
    }

    // DP status node
    private class Node {
        int rob;
        int skip;
        Node(int _rob, int _skip) {
            rob = _rob;
            skip = _skip;
        }
    }

    private Node traverse(TreeNode root) {
        Node node = new Node(0, 0);
        if (root == null) {
            return node;
        }

        Node left = traverse(root.left);
        Node right = traverse(root.right);

        // postorder
        node.rob = root.val + left.skip + right.skip;
        node.skip = Math.max(left.rob, left.skip) + Math.max(right.rob, right.skip);
        return node;
    }
}
