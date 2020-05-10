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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        traverse(ret, root, 0);
        Collections.reverse(ret);
        return ret;
    }

    private void traverse(List<List<Integer>> ret, TreeNode root, int level) {
        if (root == null) return;
        if (ret.size()-1 < level)
            ret.add(new ArrayList<Integer>());
        ret.get(level).add(root.val);
        traverse(ret, root.left, level+1);
        traverse(ret, root.right, level+1);
    }
}
