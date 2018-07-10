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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        helper(ret, root, 0);
        return ret;
    }

    private void helper(List<Integer> ret, TreeNode node, int level) {
        if (node == null) return;
        if (level >= ret.size()) {
            ret.add(Integer.MIN_VALUE);
        }
        ret.set(level, Math.max(ret.get(level), node.val));
        helper(ret, node.left, level+1);
        helper(ret, node.right, level+1);
    }
}
