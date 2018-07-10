/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// without extra space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        // make the new copy btw the original node and its next
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.random = p.random;
            copy.next = p.next;
            p.next = copy;
            p = p.next.next;
        }

        // note here: in this iteration, only update the random pointer, do not separate these two lists
        p = head;
        RandomListNode q = p.next;;
        while (p != null) {
            q = p.next;
            q.random = q.random == null ? null : q.random.next;
            p = q.next;
        }

        // pick the copied nodes out and form a list
        p = head;
        RandomListNode dh = new RandomListNode(0);
        q = dh;
        while (p != null) {
            q.next = p.next;
            p.next = p.next.next;
            p = p.next;
            q = q.next;
        }

        return dh.next;
    }
}

// // need extra space
// public class Solution {
//     public RandomListNode copyRandomList(RandomListNode head) {
//         Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//         RandomListNode p = head;
//         RandomListNode dh = new RandomListNode(0);
//         RandomListNode q = dh;
// 
//         while (p != null) {
//             // copy current node
//             RandomListNode cur = map.get(p);
//             if (cur == null) {
//                 cur = new RandomListNode(p.label);
//                 map.put(p, cur);
//             }
// 
//             // copy random pointer
//             RandomListNode random;
//             if (p.random == null) {
//                 random = null;
//             } else {
//                 random = map.get(p.random);
//                 if (random == null) {
//                     random = new RandomListNode(p.random.label);
//                     map.put(p.random, random);
//                 }
//             }
// 
//             cur.random = random;
//             q.next = cur;
//             q = q.next;
//             p = p.next;
//         }
// 
//         return dh.next;
//     }
// }
