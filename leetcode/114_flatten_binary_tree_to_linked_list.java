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

    // record the nearest predecessor
    private TreeNode last = null;

    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // preorder ops
        last = root;

        flatten(root.left);

        // inorder ops
        TreeNode lowest = last;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;

        flatten(tmp);

        // postorder ops
        lowest.right = tmp;
    }
}
