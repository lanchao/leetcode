package org.supersense.leetcode.problems.p206;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
        	return head;
        }

        ListNode curr = head;
        ListNode tail = curr;
        ListNode next = curr.next;
        ListNode nextnext = null;
        while(next != null){
        	nextnext = next.next;
        	next.next = curr;
        	curr = next;
        	next = nextnext;
        }
        tail.next = next;
        return curr;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(m >= n){
    		return head;
    	}
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode tail = h;
        for(int i = 1; i < m; i++){
        	tail = tail.next;
        }
        ListNode curr = tail.next;
        ListNode ntail = curr;
        ListNode next = curr.next;
        for(int i = m; i < n && next != null; i++){
        	ListNode tmp = next.next;
        	next.next = curr;
        	curr = next;
        	next = tmp;   	
        }
        tail.next = curr;
        ntail.next = next;
        return h.next;
    }
}
