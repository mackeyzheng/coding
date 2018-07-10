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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }

    private TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int posE) {
        if (inS > inE) return null;
        TreeNode node = new TreeNode(postorder[posE]);
        int index = inS;
        while (index <= inE && inorder[index] != postorder[posE]) {
            index++;
        }
        node.left = build(inorder, inS, index-1, postorder, posE-1-inE+index);
        node.right = build(inorder, index+1, inE, postorder, posE-1);
        return node;
    }
}
