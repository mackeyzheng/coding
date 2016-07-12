/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// solution 1
// instead of 2 pointers, use circle list method
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null | k == 0) return head;
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }

        // refine k
        k = len - k % len; // note here, k may be larger than the length
        p.next = head;     // circle the list here (use p as a dummy head)
        while (k-- > 0) {
            p = p.next;
        }

        // rotate
        head = p.next;
        p.next = null;

        return head;
    }
}

// // solution 2
// public class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if (head == null | k == 0) return head;
// 
//         ListNode dh = new ListNode(0);
//         dh.next = head;
//         ListNode p = dh;
//         int len = 0;
//         while (p.next != null) {
//             p = p.next;
//             len++;
//         }
// 
//         // refine k
//         k = len - k % len;
//         ListNode q = dh;
//         while (k-- > 0) {
//             q = q.next;
//         }
// 
//         // rotate
//         p.next = dh.next;
//         dh.next = q.next;
//         q.next = null;
// 
//         return dh.next;
//     }
// }
