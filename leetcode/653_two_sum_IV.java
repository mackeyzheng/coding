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
    // backtracking + memo
    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k, new HashSet<>());
    }

    // inorder traverse
    private boolean helper(TreeNode node, int k, Set<Integer> memo) {
        if (node == null) return false;
        if (memo.contains(k - node.val)) return true;
        memo.add(node.val);
        return helper(node.left, k, memo) || helper(node.right, k, memo);
    }
}
