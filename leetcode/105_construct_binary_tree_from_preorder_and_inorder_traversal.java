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
    // assumption: no duplicates
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, inorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (preStart == preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inStart;
        while (inorder[inIndex] != root.val) {
            inIndex++;
        }
        root.left = dfs(preorder, preStart+1, inorder, inStart, inIndex-1);
        root.right = dfs(preorder, preStart+1+inIndex-inStart, inorder, inIndex+1, inEnd);
        return root;
    }
}
