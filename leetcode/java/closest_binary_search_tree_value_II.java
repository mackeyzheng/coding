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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> pre = new LinkedList<>();
        Deque<TreeNode> post = new LinkedList<>();
        while (root != null) {
            if (root.val < target) {
                pre.push(root);
                root = root.right;
            } else {
                post.push(root);
                root = root.left;
            }
        }
        while (ret.size() < k) {
            TreeNode preNode = pre.peek();
            TreeNode postNode = post.peek();
            if (preNode == null && postNode == null) return ret;
            if (preNode == null) {
                ret.add(postNode.val);
                getNextPost(post);
            } else if (postNode == null) {
                ret.add(preNode.val);
                getNextPre(pre);
            } else {
                if (target - preNode.val < postNode.val - target) {
                    ret.add(preNode.val);
                    getNextPre(pre);
                } else {
                    ret.add(postNode.val);
                    getNextPost(post);
                }
            }
        }
        return ret;
    }

    private TreeNode getNextPre(Deque<TreeNode> pre) {
        if (pre.isEmpty()) return null;
        TreeNode ret = pre.pop();
        TreeNode cur = ret.left;
        while (cur != null) {
            pre.push(cur);
            cur = cur.right;
        }
        return ret;
    }

    private TreeNode getNextPost(Deque<TreeNode> post) {
        if (post.isEmpty()) return null;
        TreeNode ret = post.pop();
        TreeNode cur = ret.right;
        while (cur != null) {
            post.push(cur);
            cur = cur.left;
        }
        return ret;
    }
}
