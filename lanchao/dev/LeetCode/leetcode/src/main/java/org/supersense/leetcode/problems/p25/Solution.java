package org.supersense.leetcode.problems.p25;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0);
        h.next = head;
        int count = 0;
        ListNode tail = h;
        ListNode currhead = h.next;
        ListNode currtail = tail;
        ListNode curr = currhead;
        while(curr != null){
        	count ++;
        	currtail = curr;
        	if(count == k){
        		count--;
        		ListNode currnext = curr.next;
        		curr = currhead;
        		ListNode pre = curr;
    			ListNode next = curr.next;
        		while(count != 0){
        			curr = next;
        			next = next.next;
        			curr.next = pre;
        			pre = curr;
        			count --;
        		}
        		tail.next = curr;
        		tail = currhead;
        		currtail = tail;
        		curr = currnext;
        		currhead = currnext;
        		currtail.next = currnext;
        	}else{
        		curr = curr.next;
        	}
        }
        currtail.next = null;
        return h.next;
    }
}
