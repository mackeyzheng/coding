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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        p.next = l1;
        ListNode q = l2;
        int carry = 0;

        while(p.next != null && q != null) {
           int ret = p.next.val + q.val + carry;
           p.next.val = ret % 10;
           carry = ret / 10;
           p = p.next;
           q = q.next;
        }

        if (p.next == null) {
            p.next = q;
        }

        while (p.next != null && carry > 0) {
            int ret = p.next.val + carry;
            p.next.val = ret % 10;
            carry = ret / 10;
            p = p.next;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return l1;
    }
}
