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
            TreeNode suc = !successor.isEmpty() ? successor.peek() : null;
            TreeNode pre = !predecessor.isEmpty() ? predecessor.peek() : null;
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
        TreeNode suc = stack.pop();
        res.add(suc.val);
        if (suc.right != null) {
            suc = suc.right;
            stack.push(suc);
            while (suc.left != null) {
                suc = suc.left;
                stack.push(suc);
            }
        }
    }

    private void nextPredecessor(List<Integer> res, Deque<TreeNode> stack) {
        TreeNode pre = stack.pop();
        res.add(pre.val);
        if (pre.left != null) {
            pre = pre.left;
            stack.push(pre);
            while (pre.right != null) {
                pre = pre.right;
                stack.push(pre);
            }
        }
    }
}
