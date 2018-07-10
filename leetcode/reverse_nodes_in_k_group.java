/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null) return head;

        ListNode dh = new ListNode(0);
        dh.next = head;
        ListNode p = dh;
        ListNode q = head;
        int n = 1;
        while (q != null) {
            if (n < k) {
                q = q.next;
                n++;
            } else {
                p = reverse(p, q); // reverse p.next to q, update p and q
                q = p.next;
                n = 1;
            }
        }

        return dh.next;
    }

    private ListNode reverse(ListNode prev, ListNode tail) {
        ListNode end = tail.next;
        ListNode cur = prev.next;
        while (cur.next != end) {
            ListNode tmp = prev.next;
            ListNode node = cur.next;
            cur.next= node.next;
            prev.next = node;
            node.next = tmp;
        }

        return cur;
    }
}
