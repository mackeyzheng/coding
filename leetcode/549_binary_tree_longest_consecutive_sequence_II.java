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
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return max;
    }

    private int max = 0;

    // return longest length of increasing and decreasing path ending at node
    private int[] longestPath(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int inc = 1;
        int dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inc = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inc = Math.max(inc, r[0] + 1);
        }
        // added current node twice, need to remove it
        max = Math.max(max, inc + dcr - 1);
        return new int[]{inc, dcr};
    }
}
