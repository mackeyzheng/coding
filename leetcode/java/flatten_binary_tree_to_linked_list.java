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
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		
		flatten(root.left);
		flatten(root.right);

		if (root.left == null) {
			return;
		}
		
		TreeNode p = root.left;
		while (p.right != null) {
			p = p.right;
		}

		p.right = root.right;
		root.right = root.left;
		root.left = null;
	}

}

// public class Solution {
// 	public void flatten(TreeNode root) {
// 		helper(root);
// 	}
// 
// 	// return the tail of the result list
// 	private TreeNode helper(TreeNode root) {
// 		if (root == null || 
// 			root.left == null && root.right == null) {
// 			return root;
// 		}
// 
// 		TreeNode left_tail = helper(root.left);
// 		TreeNode right_tail = helper(root.right);
// 		if (root.left == null) {
// 			return right_tail;
// 		}
// 
// 		if (root.right == null) {
// 			root.right = root.left;
// 			root.left = null;
// 			return left_tail;
// 		}
// 
// 		left_tail.right = root.right;
// 		root.right = root.left;
// 		root.left = null;
// 		return right_tail;
// 	}
// }
