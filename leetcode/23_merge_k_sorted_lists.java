/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // solution2: divide and conquer, like merge sort, O(nlgn)
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int s, int e) {
        if (s > e) return null;
        if (s == e) return lists[s];
        int m = s + (e - s) / 2;
        return merge(mergeKLists(lists, s, m), mergeKLists(lists, m + 1, e));
    }

    // merge two sorted lists
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode dh = new ListNode(0);
        ListNode p = dh;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
            // p.next = null;
        }
        p.next = a != null ? a : b;
        return dh.next;
    }

    // solution1: heap (priority queue) - O(nlgk): n is the number of total nodes, k is the number of lists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode dh = new ListNode(0);
        ListNode p = dh;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode cur : lists) {
            // input lists may contain null
            if (cur != null)
                pq.offer(cur);
        }
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            // only one sorted list left
            if (pq.isEmpty()) {
                p.next = cur;
                break;
            }
            // add to result
            p.next = cur;
            p = p.next;
            // add next node to pq
            if (cur.next != null) {
                pq.offer(cur.next);
            }
            // disconnect cur from list
            cur.next = null;
        }
        return dh.next;
    }
}
