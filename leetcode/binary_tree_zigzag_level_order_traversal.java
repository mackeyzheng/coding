/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        traverse(ret, root, 0, true);
        return ret;
    }

    private void traverse(List<List<Integer>> ret, TreeNode root, int level, boolean forward) {
        if (root == null) return;
        if (ret.size()-1 < level)
            ret.add(new ArrayList<Integer>());

        if (forward)
            ret.get(level).add(root.val);
        else
            ret.get(level).add(0, root.val);

        traverse(ret, root.left, level+1, !forward);
        traverse(ret, root.right, level+1, !forward);
    }
}
