/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // solution2
    // use dummy head
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        // second half head is p.next
        // after reverse, second half head is q
        q = reverse(p);
        // split list here
        p.next = null;
        p = head;
        while (q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return p == null || p.next == null;
    }

    private ListNode reverse(ListNode prevHead) {
        if (prevHead.next == null) return null;
        ListNode cur = prevHead.next;
        while (cur.next != null) {
            ListNode node = cur.next;
            cur.next = node.next;
            node.next = prevHead.next;
            prevHead.next = node;
        }
        return prevHead.next;
    }

    // solution1
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
