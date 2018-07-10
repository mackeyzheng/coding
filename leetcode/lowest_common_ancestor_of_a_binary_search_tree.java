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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val)
            return lowestCommonAncestor(root, q, p);

        if (root == null)
            return root;

        if (root.val < p.val)
            return lowestCommonAncestor(root.right, p, q);
        
        if (root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        return root;
    }
}
