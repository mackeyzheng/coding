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
    // change to cycle problem
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

    // solution2: calculate length
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int len(ListNode node) {
        int ret = 0;
        while (node != null) {
            node = node.next;
            ret++;
        }
        return ret;
    }
}
