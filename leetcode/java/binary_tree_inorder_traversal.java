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
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> ret = new ArrayList<Integer>();
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode cur = root;
//		while (!stack.isEmpty() || cur != null) {
//			while (cur != null) {
//				stack.push(cur);
//				cur = cur.left;
//			}
//			cur = stack.pop();
//			ret.add(cur.val);
//			cur = cur.right;
//		}
//
//		return ret;
//	}

	public List<Integer> inorderTraversal(TreeNode root) {
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
					prev.right = cur;
					cur = cur.left;
				} else {
					ret.add(cur.val);
					prev.right = null;
					cur = cur.right;
				}
			}
		}

		return ret;
	}
}
