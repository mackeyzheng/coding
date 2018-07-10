/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
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

//    // iterative
//    public ListNode reverseList(ListNode head) {
//        if (head == null) // this is necessary, otherwise cur.next will give NULLPointer exception
//            return null;
//
//        ListNode dh = new ListNode(0);
//        dh.next = head;
//        ListNode cur = head;
//
//        while (cur.next != null) {
//            ListNode tmp = cur.next;
//            cur.next = tmp.next;
//            tmp.next = dh.next;
//            dh.next = tmp;
//        }
//
//        return dh.next;
//    }
}
