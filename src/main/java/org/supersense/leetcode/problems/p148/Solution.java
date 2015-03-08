package problems.p148;

public class Solution {
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}
	
	private ListNode mergeSort(ListNode head){
		if(head == null || head.next == null){
			return head;
		}	
		ListNode right = dividList(head);
		ListNode left = head;
		ListNode sortedLeft = mergeSort(left);
		ListNode sortedRight = mergeSort(right);
		return merge(sortedLeft, sortedRight);
	}
	
	private ListNode merge(ListNode l1, ListNode l2){
		ListNode ret = new ListNode(0);
		ListNode m = ret;
		while(l1 != null&& l2 != null){
			if(l1.val < l2.val){
				m.next = l1;
				l1 = l1.next;
			}else{
				m.next = l2;
				l2 = l2.next;
			}
			m = m.next;
		}
		if(l1 != null){
			m.next = l1;
		}else if(l2 != null){
			m.next = l2;
		}
		return ret.next;
	}
	
	private ListNode dividList(ListNode l){
		int count = 0;
		ListNode h = l;
		ListNode ret = l;
		ListNode bef = ret;
		while(h != null){
			h = h.next;
			count ++;
			if(count % 2 == 0){
				bef = ret;
				ret = ret.next;
			}
		}
		bef.next = null;
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
