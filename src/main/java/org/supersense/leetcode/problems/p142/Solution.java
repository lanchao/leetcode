package org.supersense.leetcode.problems.p142;

public class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode l1 = head;
		ListNode l2 = head;
		while (l2 != null && l2.next != null) {
			l1 = l1.next;
			l2 = l2.next.next;
			if (l1 == l2)
				break;
		}
		if (l2 == null || l2.next == null) {
			return null;
		}
		ListNode h = head;
		while (h != l1) {
			h = h.next;
			l1 = l1.next;
		}
		return h;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}