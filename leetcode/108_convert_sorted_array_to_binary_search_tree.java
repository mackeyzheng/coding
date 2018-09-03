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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int s, int e) {
        if (s > e)
            return null;
        int m = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = build(nums, s, m - 1);
        node.right = build(nums, m + 1, e);
        return node;
    }
}
