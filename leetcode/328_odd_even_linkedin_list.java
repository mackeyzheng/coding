/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(0);
        ListNode p = oddHead;
        ListNode q = evenHead;
        ListNode cur = head;
        boolean isOdd = true;

        // note: cannot use ListNode r = isOdd ? p : q;
        // because r is a copy value of p or q
        // when do r = r.next, p or q will not change
        while (cur != null) {
            if (isOdd) {
                p.next = cur;
                cur = cur.next;
                p = p.next;
                p.next = null;
            } else {
                q.next = cur;
                cur = cur.next;
                q = q.next;
                q.next = null;
            }
            isOdd = !isOdd;
        }
        p.next = evenHead.next;
        evenHead.next = null;
        return oddHead.next;
    }
}
