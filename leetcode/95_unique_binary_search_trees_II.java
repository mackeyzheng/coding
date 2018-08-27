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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>(); // corner case
        }
        // divide and conquer
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int s, int e) {
        List<TreeNode> ret = new ArrayList<>();
        if (s > e) {
            ret.add(null); // add a null node to the list
            return ret;
        }

        // choose the parent node iteratively
        for (int i = s; i <= e; i++) {
            List<TreeNode> leftsub = generateTrees(s, i - 1);
            List<TreeNode> rightsub = generateTrees(i + 1, e);
            // combination left sub tree and right sub tree
            for (TreeNode left : leftsub) {
                for (TreeNode right : rightsub) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    ret.add(node);
                }
            }
        }

        return ret;
    }
}
