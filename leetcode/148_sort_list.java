/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// sort a linked list in O(nlgn) time using constant space complexity
// use modified merge sort
public class Solution {
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        return mergeSort(head, 0, len-1);
    }

    private ListNode mergeSort(ListNode head, int start, int end) {
        if (start >= end)
            return head;
        
        int mid = start + (end - start) / 2;
        ListNode p = head;
        int pos = mid;
        while (pos-- > start) { // note here: pos-- > start, not > 0
            p = p.next;
        }

        ListNode rightHead = p.next;
        p.next = null;

        head = mergeSort(head, start, mid);
        rightHead = mergeSort(rightHead, mid+1, end);

        return mergeList(head, rightHead);
    }

    private ListNode mergeList(ListNode x, ListNode y) {
        ListNode dh = new ListNode(0);
        ListNode p = dh;
        while (x != null && y != null) {
            if (x.val > y.val) {
                p.next = y;
                y = y.next;
            } else {
                p.next = x;
                x = x.next;
            }

            p = p.next;
        }
        p.next = x != null ? x : y;

        return dh.next;
    }
}
