/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = dummy;

        while (p != null && q != null) {
            ListNode cur = null;
            if (p.val < q.val) {
                cur = p;
                p = p.next;
            } else {
                cur = q;
                q = q.next;
            }

            cur.next = null;
            r.next = cur;
            r = r.next;
        }

        r.next = p != null ? p : q;
        return dummy.next;
    }
}
