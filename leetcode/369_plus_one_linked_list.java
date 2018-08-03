/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // reverse twice
    public ListNode plusOne(ListNode head) {
        ListNode preHead = reverse(head);
        ListNode cur = preHead;
        int carry = 1;
        while (cur.next != null && carry != 0) {
            int sum = cur.next.val + carry;
            carry = sum / 10;
            cur.next.val = sum % 10;
            cur = cur.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(preHead.next).next;
    }

    private ListNode reverse(ListNode head) {
        ListNode dh = new ListNode(0);
        dh.next = head;
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = dh.next;
            dh.next = cur;
        }
        return dh;
    }

    // recursive
    public ListNode plusOne(ListNode head) {
        if (helper(head) == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }

    private int helper(ListNode node) {
        if (node == null) return 1;
        int sum = node.val + helper(node.next);
        node.val = sum % 10;
        return sum / 10;
    }

    // iterative - stack
    public ListNode plusOne(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        int carry = 1;
        while (!stack.isEmpty()) {
            ListNode cur = stack.pop();
            int sum = cur.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            if (carry == 0) break;
        }

        if (stack.isEmpty() && carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }

        return head;
    }
}
