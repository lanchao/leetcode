package org.supersense.leetcode.problems.p160;

public class Solution {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int countA = count(headA);
	        int countB = count(headB);
	        ListNode ha = headA;
	        ListNode hb = headB;
	        if(countA > countB){
	        	int diff = countA -countB;
	        	for(int i=0;i<diff;i++){
	        		ha = ha.next;
	        	}
	        }else if(countA < countB){
	        	int diff = countB - countA;
	        	for(int i = 0 ; i< diff; i++){
	        		hb = hb.next;
	        	}
	        }
	        while(ha!=null&&hb!=null){
	        	if(ha == hb){
	        		return ha;
	        	}
	        	ha = ha.next;
	        	hb = hb.next;
	        }
	        return null;
	 }

	private int count(ListNode head) {
		int c = 0;
		while(head!=null){
			head = head.next;
			c++;
		}
		return c;
	}
}
