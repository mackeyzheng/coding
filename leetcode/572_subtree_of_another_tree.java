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
    // O(mn)
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == null && t == null;
        if (check(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean check(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return a == null && b == null;
        }
        if (a.val != b.val) return false;
        return check(a.left, b.left) && check(a.right, b.right);
    }
}
