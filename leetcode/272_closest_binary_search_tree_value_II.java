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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> successor = new ArrayDeque<>();
        Deque<TreeNode> predecessor = new ArrayDeque<>();
        while (root != null) {
            if (root.val > target) {
                successor.push(root);
                root = root.left;
            } else {
                // root.val <= target
                predecessor.push(root);
                root = root.right;
            }
        }
        while (res.size() < k) {
            TreeNode suc = successor.peek();
            TreeNode pre = predecessor.peek();
            if (suc == null || pre == null) {
                if (pre != null) {
                    // handle pre
                    nextPredecessor(res, predecessor);
                } else {
                    // handle suc
                    nextSuccessor(res, successor);
                }
            } else if (suc.val - target < target - pre.val) {
                // handle suc
                nextSuccessor(res, successor);
            } else {
                // handle pre
                nextPredecessor(res, predecessor);
            }
        }
        return res;
    }

    private void nextSuccessor(List<Integer> res, Deque<TreeNode> stack) {
        TreeNode node = stack.pop();
        res.add(node.val);
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private void nextPredecessor(List<Integer> res, Deque<TreeNode> stack) {
        TreeNode node = stack.pop();
        res.add(node.val);
        node = node.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }
}
