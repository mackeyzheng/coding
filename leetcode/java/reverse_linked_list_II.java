/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dh = new ListNode(0);
        dh.next = head;
        ListNode p = dh;
        ListNode q = head;
        n -= m;

        while (n-- > 0) {
            q = q.next;
        }

        while (--m > 0) {
            p = p.next;
            q = q.next;
        }

        // reverse p.next ot q
        ListNode cur = p.next;
        ListNode end = q.next;
        while (cur.next != end) {
            ListNode tmp = p.next;
            ListNode node = cur.next;
            cur.next = node.next;
            p.next = node;
            node.next = tmp;
        }

        return dh.next;
    }
}
