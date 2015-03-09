package org.supersense.leetcode.problems.p2;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode ret = null;
		ListNode prehead = ret;
		ListNode currhead = prehead;
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		int digit = 0;
		int sum = 0;
		while (curr1 != null && curr2 != null) {
			sum = curr1.val + curr2.val + digit;
			digit = sum / 10;
			sum %= 10;
			if (ret == null) {
				ret = new ListNode(sum);
				currhead = ret;
				curr1 = curr1.next;
				curr2 = curr2.next;
			} else {
				currhead.next = new ListNode(sum);
				curr1 = curr1.next;
				curr2 = curr2.next;
				currhead = currhead.next;
			}
		}
		ListNode curr = (curr1 == null) ? curr2 : curr1;
		if (curr != null) {
			while (digit > 0) {
				if(curr == null){
					break;
				}
				sum = curr.val + digit;
				digit = sum / 10;
				sum %= 10;
				currhead.next = new ListNode(sum);
				curr = curr.next;
				currhead = currhead.next;
			}
			currhead.next = curr;
		}
		if (digit > 0) {
			currhead.next = new ListNode(digit);
		}

		return ret;
	}
}
