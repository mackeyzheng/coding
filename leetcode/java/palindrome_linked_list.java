/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // time: O(n), space: O(1)
    // reverse the second half and compare
    public boolean isPalindrome(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        if (f != null) { // odd nodes: right half must be smaller
            s = s.next;
        }
        f = head;
        s = reverse(s);
        while (s != null) {
            if (f.val != s.val) return false;
            f = f.next;
            s = s.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
