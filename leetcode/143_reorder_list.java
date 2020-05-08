/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode dh = new ListNode();
        dh.next = head;
        ListNode p = dh;
        ListNode q = dh;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }

        q = p.next; // second head
        p.next = null;

        q = reverse(q);
        p = head;

        while (p != null && q != null) {
            ListNode nextP = p.next;
            ListNode nextQ = q.next;
            p.next = q;
            q.next = nextP;
            p = nextP;
            q = nextQ;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dh = new ListNode();
        dh.next = head;
        while (head.next != null) {
            ListNode node = head.next;
            head.next = node.next;
            node.next = dh.next;
            dh.next = node;
        }
        return dh.next;
    }
}
