/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// assumption: no duplicates exist in the tree
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null
            || inorder.length != postorder.length)
            return null;

        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int in_s, int in_e, int[] postorder, int p_s, int p_e) {
        if (in_s > in_e || p_s > p_e)
            return null;

        TreeNode node = new TreeNode(postorder[p_e]);
        int right_len = 0;
        for (int i = in_s; i <= in_e; i++) {
            if (inorder[i] == postorder[p_e]) {
                right_len = in_e - i;
                break;
            }
        }

        node.right = buildTree(inorder, in_e-right_len+1, in_e, postorder, p_e-right_len, p_e-1);
        node.left = buildTree(inorder, in_s, in_e-right_len-1, postorder, p_s, p_e-right_len-1);

        return node;
    }
}
