package org.supersense.leetcode.problems.p19;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode newhead = new ListNode(0);
		newhead.next = head;
		ListNode curr = head;
		ListNode pre = newhead;
		for (int i = 0; i < n; i++) {
			curr = curr.next;
		}
		while (curr != null) {
			curr = curr.next;
			pre = pre.next;

		}
		ListNode next =  pre.next.next;
		pre.next = next;
		return newhead.next;
	}
}
