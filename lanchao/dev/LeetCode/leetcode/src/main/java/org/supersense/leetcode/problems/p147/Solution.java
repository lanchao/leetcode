package problems.p147;

public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode ret = head;
		head = head.next;
		ret.next = null;
		while (head != null) {
			ListNode p = ret;
			ListNode pre = p;
			ListNode tmp = head.next;
			while (p != null) {
				if (p.val > head.val) {
					if (pre == p) {
						head.next = p;
						ret = head;
					} else {
						pre.next = head;
						head.next = p;
					}
					break;
				}
				pre = p;
				p = p.next;
			}
			if (p == null) {
				pre.next = head;
				head.next = null;
			}
			head = tmp;
		}
		return ret;
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