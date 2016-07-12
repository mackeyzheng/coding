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
        while (root != null) {
            // use dummy head
            TreeLinkNode dh = new TreeLinkNode(0);
            TreeLinkNode cur = root;
            TreeLinkNode prev = dh;
            // while traversing the current level, initialize the next level
            while (cur != null) {
                if (cur.left != null) {
                    prev.next = cur.left;
                    prev = prev.next;
                }
                if (cur.right != null) {
                    prev.next = cur.right;
                    prev = prev.next;
                }
                cur = cur.next;
            }
            // update root to go to next level
            root = dh.next;
        }
    }
}
