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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        traverse(root, 0, true, ret);
        return ret;
    }

    private void traverse(TreeNode node, int level, boolean forward, List<List<Integer>> ret) {
        if (node == null) {
            return;
        }
        if (level >= ret.size()) {
            ret.add(new ArrayList<>());
        }
        if (forward) {
            ret.get(level).add(node.val);
        } else {
            ret.get(level).add(0, node.val);
        }
        traverse(node.left, level + 1, !forward, ret);
        traverse(node.right, level + 1, !forward, ret);
    }
}
