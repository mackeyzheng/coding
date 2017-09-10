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
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        pathSum(ret, new LinkedList<>(), root, sum);
        return ret;
    }

    private void pathSum(List<List<Integer>> ret, List<Integer> path, TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<>(path));
        } else {
            pathSum(ret, path, root.left, sum);
            pathSum(ret, path, root.right, sum);
        }
        path.remove(path.size()-1);
    }
}
