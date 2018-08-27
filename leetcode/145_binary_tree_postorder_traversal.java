/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	// Morris
    // add a dump node, dump.left = root
    // output the nodes in reverse order on the path from cur.left to prev when prev.right = cur
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		TreeNode dh = new TreeNode(-1);
		dh.left = root;
		TreeNode cur = dh;
		TreeNode prev = null;

		while (cur != null) {
			if (cur.left == null) {
				cur = cur.right;
			} else {
				prev = cur.left;
				while (prev.right != null && prev.right != cur) {
					prev = prev.right;
				}

				if (prev.right == null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					prev.right = null; // restore the right child pointer
					// add nodes from cur.left to prev (right childern) to result list, in reverse order
					visit(cur.left, prev, ret);
					cur = cur.right;
				}
			}
		}

		return ret;
	}

	private void visit(TreeNode from, TreeNode to, List<Integer> ret) {
		reverse(from, to);

		// add nodes to result list to --> from
		TreeNode p = to;
		while (p != null) {
			ret.add(p.val);
			p = p.right;
		}

		reverse(to, from);
	}

	private void reverse(TreeNode from, TreeNode to) {
		if (from == to) return;

		TreeNode x = from;
		TreeNode y = from.right;
		TreeNode z;

        from.right = null; // from is the tail now, cut the following nodes
		while (x != to) {
			z = y.right;
			y.right = x;
			x = y;
			y = z;
		}
    }

    // iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if ((cur.left == null && cur.right == null) || // leaf node
                (cur.left != null && cur.left == prev || cur.right != null && cur.right == prev)) { // prev is a child of cur
                ret.add(cur.val);
                stack.pop();
            } else {
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
            prev = cur;
        }
        return ret;
    }


	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode prev = null;

		// handle a subtree per loop
		do {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			prev = null;
			while (!stack.isEmpty()) {
				cur = stack.peek();
				if (cur.right == prev) {
					ret.add(cur.val);
					prev = cur;
					stack.pop();
				} else {
					cur = cur.right;
					break;
				}
			}
		} while (!stack.isEmpty());

		return ret;
	}

}
