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
        // use dummy head
        TreeLinkNode dh = new TreeLinkNode(0);
        while (root != null) {
            TreeLinkNode prev = dh;
            // while traversing the current level, initialize the next level
            while (root != null) {
                if (root.left != null) {
                    prev.next = root.left;
                    prev = prev.next;
                }
                if (root.right != null) {
                    prev.next = root.right;
                    prev = prev.next;
                }
                root = root.next;
            }
            // update root to go to next level
            root = dh.next;
            // reset dummy head
            dh.next = null;
        }
    }
}
