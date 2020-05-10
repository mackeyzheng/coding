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
    // solution2: add small list to large one, use recurrsive call to update value and get carry
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode ret = new ListNode();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            ret.val = sum % 10;
            ListNode node = new ListNode();
            node.next = ret;
            ret = node;

            sum /= 10;
        }

        if (sum > 0) {
            ret.val = sum;
            return ret;
        }

        return ret.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode p = l1;
        while (p != null) {
            p = p.next;
            len1++;
        }
        p = l2;
        while (p != null) {
            p = p.next;
            len2++;
        }

        if (len2 > len1) {
            return addTwoNumbers(l2, l1);
        }

        p = l1;
        for (int i = 0; i < len1 - len2; i++) {
            l1 = l1.next;
        }

        while (l1 != null) {
            l1.val = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }

        int carry = propagate(p);

        if (carry > 0) {
            ListNode ret = new ListNode(carry);
            ret.next = p;
            return ret;
        }

        return p;
    }

    // propagate to update node.val and get carry
    private int propagate(ListNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + propagate(node.next);
        node.val = sum % 10;
        return sum / 10;
    }

    // solution1: two stacks, build up result list backwards
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode ret = new ListNode();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            ret.val = sum % 10;
            ListNode node = new ListNode();
            node.next = ret;
            ret = node;

            sum /= 10;
        }

        if (sum > 0) {
            ret.val = sum;
            return ret;
        }

        return ret.next;
    }
}
