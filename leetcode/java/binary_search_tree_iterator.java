/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class BSTIterator {
    private Stack<TreeNode> stack;
    // private TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        // cur = root;
        update(root);
    }

    private void update(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty(); // cur != null || !stack.isEmpty();
                                 // note here, it is not necessary to add the condition "cur != null"
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        update(node.right);
        return node.val;
    }
}
