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
    // bottom up, all leaves are at the bottom level (height == 0)
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        help(root, ret);
        return ret;
    }

    private int help(TreeNode node, List<List<Integer>> ret) {
        if (node == null) return -1;
        int height = 1 + Math.max(help(node.left, ret), help(node.right, ret));
        if (height >= ret.size()) {
            ret.add(new ArrayList<Integer>());
        }
        ret.get(height).add(node.val);
        return height;
    }
}
