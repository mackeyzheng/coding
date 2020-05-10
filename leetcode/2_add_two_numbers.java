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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dh = new ListNode();
        dh.next = l1;
        ListNode prev = dh;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        }

        while (prev.next != null && carry > 0) {
            int sum = prev.next.val + carry;
            carry = sum / 10;
            prev.next.val = sum % 10;
            prev = prev.next;
        }

        if (prev.next == null && carry > 0) {
            prev.next = new ListNode(carry);
        }

        return dh.next;
    }
}
