class Solution {
	public:
		ListNode *swapPairs(ListNode *head) {
			ListNode dh(-1);
			dh.next = head;
			ListNode *p = &dh;
			// swap the following two nodes of p
			while (p->next && p->next->next) {
				ListNode *q = p->next;
				ListNode *r = p->next->next;
				p->next = r;
				q->next = r->next;
				r->next = q;
				p = q;
			}
			return dh.next;
		}
};
