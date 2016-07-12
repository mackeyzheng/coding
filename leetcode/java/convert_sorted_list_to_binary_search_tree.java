/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// top-down: build the tree top-down: build parent, then left child, then right child (similar to preorder)
// but it requires random access, which linked list does not support
// --> Time Limit Exceeded
//
// bottom-up: time O(n), space O(lgn)
// build the tree bottom-up: left child, parent, right child (similar to inorder)
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // first calculate the list length
        ListNode p = head;
        int len = 0;

        while (p != null) {
            p = p.next;
            len++;
        }

        return sortedListToBST(head, 0, len-1).t;
    }

    // package ListNode and TreeNode, to solve that Java cannot return multiple values and pass by reference
    // solve that callee cannot change the caller's parameters
    private class Element {
        ListNode l; // this is the head of the next unconverted list
        TreeNode t; // this is the current treenode that just created
        public Element(ListNode l, TreeNode t) {
            this.l = l;
            this.t = t;
        }
    }

    private Element sortedListToBST(ListNode head, int start, int end) {
        if (start > end)
            return new Element(head, null);

        int mid = start + (end - start) / 2; // or mid = start + ((end - start) >> 1)
        Element leftchild = sortedListToBST(head, start, mid-1);
        head = leftchild.l;
        TreeNode node = new TreeNode(head.val);
        node.left = leftchild.t;
        head = head.next; // important: update head, move right by one
        Element rightchild = sortedListToBST(head, mid+1, end);
        node.right = rightchild.t;

        return new Element(rightchild.l, node); // rightchild.l is the latest version
    }
}
