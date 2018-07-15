/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode p = root;
        // iterate vertically
        while (p != null) {
            TreeLinkNode cur = dummy;
            // iterate horizontally
            // while traversing current level, initialize next level
            while (p != null) {
                if (p.left != null) {
                    cur.next = p.left;
                    cur = cur.next;
                }
                if (p.right != null) {
                    cur.next = p.right;
                    cur = cur.next;
                }
                p = p.next;
            }
            // update pointer to go to next level
            p = dummy.next;
            // reset dummy head
            dummy.next = null;
        }
    }
}
