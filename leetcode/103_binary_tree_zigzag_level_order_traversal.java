/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        traverse(root, 0, ret);
        return ret;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> ret) {
        if (node == null) {
            return;
        }

        if (level >= ret.size()) {
            ret.add(new ArrayList<>());
        }

        if ((level & 1) == 0) {
            ret.get(level).add(node.val);
        } else {
            ret.get(level).add(0, node.val);
        }

        traverse(node.left, level + 1, ret);
        traverse(node.right, level + 1, ret);
    }
}
