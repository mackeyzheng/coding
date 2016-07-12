/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dh = new ListNode(0);
        ListNode cur = dh;
        PriorityQueue<ListNode> heap =
            new PriorityQueue<ListNode>(lists.length,
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode n1, ListNode n2) {
                        return n1.val - n2.val;
                    }
                });

        for (ListNode iter : lists) {
            if (iter == null) continue;
            heap.offer(iter);
        }

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            node = node.next;
            if (node != null)
                heap.offer(node);
        }

        return dh.next;
    }
}
