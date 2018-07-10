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
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        helper(root, map, 0);
        List<Integer> ret = new ArrayList<Integer>(map.values());
        return ret;
    }

    private void helper(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root == null) return;

        if (!map.containsKey(level)) {
            map.put(level, root.val);
        }
        // right child first, then left
        helper(root.right, map, level+1);
        helper(root.left, map, level+1);
    }
}
