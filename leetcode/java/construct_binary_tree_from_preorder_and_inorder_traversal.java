/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// assumption: duplicates do not exist in the tree
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
            || preorder.length != inorder.length)
            return null;

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int pre_s, int pre_e, int[] inorder, int in_s, int in_e) {
        if (pre_s > pre_e || in_s > in_e)
            return null;

        TreeNode node = new TreeNode(preorder[pre_s]);
        int left_len = 0;
        for (int i = in_s; i <= in_e; i++) {
            if (inorder[i] == preorder[pre_s]) {
                left_len = i - in_s;
                break;
            }
        }

        node.left = buildTree(preorder, pre_s+1, pre_s+left_len, inorder, in_s, in_s+left_len-1);
        node.right = buildTree(preorder, pre_s+left_len+1, pre_e, inorder, in_s+left_len+1, in_e);

        return node;
    }
}
