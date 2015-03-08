package org.supersense.leetcode.problems.p141;

public class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode l1 = head;
		ListNode l2 = head;
		while (l2 != null && l2.next != null) {
			l1 = l1.next;
			l2 = l2.next.next;
			if (l1 == l2)
				return true;
		}
		return false;
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