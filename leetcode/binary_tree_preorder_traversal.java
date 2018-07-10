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
//	// solution1
//	public List<Integer> preorderTraversal(TreeNode root) {
//		List<Integer> ret = new ArrayList<Integer>();
//		if (root == null) return ret;
//
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			TreeNode cur = stack.pop();
//			ret.add(cur.val);
//			if (cur.right != null) {
//				stack.push(cur.right);
//			}
//			if (cur.left != null) {
//				stack.push(cur.left);
//			}
//		}
//
//		return ret;
//	}

	// solution2: Morris
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		TreeNode cur = root;
		TreeNode prev = null;
		while (cur != null) {
			if (cur.left == null) {
				ret.add(cur.val);
				cur = cur.right;

			} else {
				prev = cur.left;
				while (prev.right != null && prev.right != cur) {
					prev = prev.right;
				}

				if (prev.right == null) {
					ret.add(cur.val);
					prev.right = cur;
					cur = cur.left;
				} else {
					cur = cur.right;
					prev.right = null;
				}
			}
		}

		return ret;
	}

}
