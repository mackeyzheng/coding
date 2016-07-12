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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        pathSum(ret, path, root, sum);
        return ret;
    }

    private void pathSum(List<List<Integer>> ret, List<Integer> path, TreeNode root, int sum) {
        if (root == null) return;

        sum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new ArrayList<Integer>(path));
        } else {
            pathSum(ret, path, root.left, sum);
            pathSum(ret, path, root.right, sum);
        }

        path.remove(path.size()-1);
    }
}
