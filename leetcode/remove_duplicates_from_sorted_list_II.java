/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// solution 1: recursively
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        if (head.val == p.val) {
            while (p != null && head.val == p.val) {
                p = p.next;
            }
            return deleteDuplicates(p);
        } else {
            head.next = deleteDuplicates(p);
            return head;
        }
    }
}

// // solution 2: iteratively
// public class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         ListNode dh = new ListNode(0);
//         ListNode r = dh;
//         ListNode p = head;
// 
//         while (p != null) {
//             ListNode q = p.next;
// 
//             if (q == null || q.val != p.val) {
//                 // insert
//                 r.next = p;
//                 r = r.next;
//             } else {
//                 while (q != null && q.val == p.val) {
//                     q = q.next;
//                 }
//             }
//             // update
//             p = q;
//         }
//         // add the last element to list (the latest p)
//         r.next = null;
// 
//         return dh.next;
//     }
// }
