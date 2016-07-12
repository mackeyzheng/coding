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
        if (nums == null) return null;

        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if (s > e) return null;

        int mid = s + (e - s + 1) / 2; // upper median
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, s, mid-1);
        node.right = helper(nums, mid+1, e);

        return node;
    }
}
