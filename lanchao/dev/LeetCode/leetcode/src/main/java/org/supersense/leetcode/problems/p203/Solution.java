package org.supersense.leetcode.problems.p203;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
        	return null;
        }
        ListNode nh = new ListNode(0);
        nh.next = head;
        ListNode curr = head;
        ListNode pre = nh;
        while(curr != null){
        	while(curr.val == val){
        		if(curr.next == null){
        			curr = null;
        			break;
        		}else{
        			curr = curr.next;
        		}
        	}
    		pre.next = curr;
    		pre = curr;
    		if(curr != null){
    			curr = curr.next;
    		}
        }
        return nh.next;
    }
}
