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
    // BFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            long count = queue.size();
            long sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ret.add(1.0*sum/count);
        }
        return ret;
    }

    // DFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        dfs(root, 0, ret, count);
        for (int i = 0; i < ret.size(); i++)
            ret.set(i, ret.get(i)/count.get(i));
        return ret;
    }

    private void dfs(TreeNode node, int level, List<Double> ret, List<Integer> count) {
        if (node == null) return;
        if (level >= ret.size()) {
            ret.add(0.0);
            count.add(0);
        }
        ret.set(level, ret.get(level)+node.val);
        count.set(level, count.get(level)+1);
        dfs(node.left, level+1, ret, count);
        dfs(node.right, level+1, ret, count);
    }
}
