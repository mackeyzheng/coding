/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // recursive
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode next = head.next;
        head.next = null;
        return reverse(head, next);
    }

    private ListNode reverse(ListNode head, ListNode next) {
        if (next == null)
            return head;
        ListNode tmp = next.next;
        next.next = head;
        return reverse(next, tmp);
    }

    // iterative
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dh = new ListNode(0);
        dh.next = head;
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = dh.next;
            dh.next = cur;
        }
        return dh.next;
    }
}
