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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return dfs(nums, 0, nums.length-1);
    }

    private TreeNode dfs(int[] nums, int s, int e) {
        if (s > e) return null;
        int m = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = dfs(nums, s, m-1);
        node.right = dfs(nums, m+1, e);
        return node;
    }
}
