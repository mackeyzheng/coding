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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), ret);
        return ret;
    }

    private void dfs(TreeNode node, int target, List<Integer> entry, List<List<Integer>> ret) {
        if (node == null)
            return;
        target -= node.val;
        entry.add(node.val);
        if (node.left == null && node.right == null) {
            if (target == 0) {
                ret.add(new ArrayList<>(entry));
            }
        } else {
            dfs(node.left, target, entry, ret);
            dfs(node.right, target, entry, ret);
        }
        entry.remove(entry.size() - 1);
    }
}
