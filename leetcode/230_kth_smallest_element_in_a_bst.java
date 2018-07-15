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
    // recursive - O(n)
    public int kthSmallest(TreeNode root, int k) {
        // 0 - result value
        // 1 - ret[1] > 0 means found
        // 2 - number of visited nodes
        int[] ret = new int[3];
        traverse(root, k, ret);
        return ret[0];
    }

    private void traverse(TreeNode node, int k, int[] ret) {
        if (node == null || ret[1] > 0) {
            return;
        }
        traverse(node.left, k, ret);
        ret[2]++;
        if (ret[2] == k) {
            ret[0] = node.val;
            ret[1] = 1;
            return;
        }
        traverse(node.right, k, ret);
    }

    // iterative - O(n)
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushAllLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (--k == 0) {
                return cur.val;
            }
            pushAllLeft(cur.right, stack);
        }
        throw new RuntimeException("not found");
    }

    private void pushAllLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // follow up: What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
    // at each node, store left subtree size (or size of left subtree + current node)
    // time reduce from O(mn) to O(mlgn + n), m is number of search operations
    private Map<TreeNode, Integer> tree = new HashMap<>();
    private Map<TreeNode, Integer> leftTree = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        update(root); // move to initialize
        while (root != null) {
            int len = leftTree.get(root);
            if (len == k) {
                return root.val;
            }
            if (len > k) {
                root = root.left;
            } else {
                root = root.right;
                k -= len;
            }
        }
        throw new RuntimeException("no solution");
    }

    private int update(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (tree.containsKey(node)) {
            return tree.get(node);
        }
        int left = update(node.left);
        leftTree.putIfAbsent(node, left + 1); // including current node
        int right = update(node.right);
        tree.put(node, left + right + 1);
        return tree.get(node);
    }
}
