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
    // bottom up, all leaves are at the bottom level (height == 0)
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }

    private int dfs(TreeNode node, List<List<Integer>> ret) {
        if (node == null)
            return -1;
        int left = dfs(node.left, ret);
        int right = dfs(node.right, ret);
        int height = Math.max(left, right) + 1;
        if (height >= ret.size()) {
            ret.add(new ArrayList<>());
        }
        ret.get(height).add(node.val);
        return height;
    }
}
