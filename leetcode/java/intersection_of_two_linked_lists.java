/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        // first, cycle list A
        ListNode p = headA;
        while (p.next != null) {
            p = p.next;
        }
        // keep this original tail node of list A
        ListNode tail = p;
        p.next = headA;

        // now, this problem becomes the detect begin point of a cycle of list B
        p = headB;
        ListNode q = headB;
        do {
            if (q == null || q.next == null) {
                tail.next = null;
                return null; // no intersection node
            }
            p = p.next;
            q = q.next.next;
        } while (p != q);

        p = headB;
        while (p != q) {
            p = p.next;
            q = q.next;
        }

        tail.next = null;
        return p;
    }
}
