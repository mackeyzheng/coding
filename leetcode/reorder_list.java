/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        // get length
        int k = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            k++;
        }

        if (k < 3) return;

        k /= 2;
        p = head;
        while (k-- > 0) {
            p = p.next;
        }

        ListNode q = p.next;
        p.next = null;

        // reverse the second part of the list
        ListNode dh = new ListNode(0);
        dh.next = q;
        while (q.next != null) {
            ListNode nn = q.next.next;
            ListNode tmp = dh.next;
            dh.next = q.next;
            q.next.next = tmp;
            q.next = nn;
        }

        // merge two lists
        p = head;
        q = dh.next;
        while (q != null) {
            ListNode tmp = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = tmp;
        }
    }
}
