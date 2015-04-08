package org.supersense.leetcode.problems.p61;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode h = head;
		int length = 1;
		while(h.next != null){
			length++;
			h = h.next;
		}
		ListNode t = h;
		t.next = head;
		for(int i = 0; i< (length - k % length); i++){
			h = h.next;
		}
		ListNode ret = h.next;
		h.next = null;
		return ret;
	}
}
