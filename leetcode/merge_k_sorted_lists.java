/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // solution2: divide and conquer O(nlgn)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int s, int e) {
        if (s > e) return null;
        if (s == e) return lists[s];
        int m = s + (e - s) / 2;
        return mergeTwoLists(mergeKLists(lists, s, m), mergeKLists(lists, m + 1, e));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null && b == null) return null;
        ListNode dm = new ListNode(0);
        ListNode p = dm;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        p.next = a != null ? a : b;
        return dm.next;
    }

    // solution1: priority queue O(nlgn)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dm = new ListNode(0);
        ListNode p = dm;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode cur : lists) {
            if (cur == null) continue;
            heap.offer(cur);
            cur = cur.next;
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            p.next = cur;
            p = p.next;
            cur = cur.next;
            if (cur != null)
                heap.offer(cur);
        }
        return dm.next;
    }
}
