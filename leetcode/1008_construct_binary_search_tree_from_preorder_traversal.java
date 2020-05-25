/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * solution2 - time O(N), space O(H)
     * Give the function a bound the maximum number it will handle.
     * The left recursion will take the elements smaller than node.val
     * The right recursion will take the remaining elements smaller than bound
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private int cur = 0;

    private TreeNode build(int[] preorder, int bound) {
        if (cur == preorder.length || preorder[cur] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[cur++]);
        node.left = build(preorder, node.val);
        node.right = build(preorder, bound);
        return node;
    }

    // solution1 - recursive + binary search
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int s, int e) {
        if (s > e) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[s]);

        if (s == e) {
            return node;
        }

        int index = search(preorder, s + 1, e, node.val);
        if (index < 0) {
            // right = null
            node.left = build(preorder, s + 1, e);
        } else if (index == s + 1) {
            // left = null
            node.right = build(preorder, s + 1, e);
        } else {
            node.left = build(preorder, s + 1, index - 1);
            node.right = build(preorder, index, e);
        }

        return node;
    }

    private int search(int[] array, int s, int e, int target) {
        while (s < e) {
            int m = s + (e - s) / 2;
            if (array[m] < target) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return array[s] > target ? s : -1;
    }
}
