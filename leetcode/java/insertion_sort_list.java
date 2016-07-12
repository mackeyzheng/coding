/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        // create a new list to be as the result sorted list
        ListNode dh = new ListNode(0);
        ListNode p = head;

        while (p != null) {
            ListNode q = dh;
            // every time, from the head of the result list, find the place where to insert the current node
            while (q.next != null && q.next.val <= p.val) {
                q = q.next;
            }
            
            // insert node p btw q and q.next
            ListNode tmp = p.next;
            p.next = q.next;
            q.next = p;
            p = tmp;
        }

        return dh.next;
    }
}
