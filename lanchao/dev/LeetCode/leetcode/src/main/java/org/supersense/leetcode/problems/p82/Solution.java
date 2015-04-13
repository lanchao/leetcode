package org.supersense.leetcode.problems.p82;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        
        ListNode tail = prehead;
        ListNode curr = head;
        while(curr != null && curr.next != null){
        	if(curr.val != curr.next.val){
        		tail.next = curr;
        		tail = tail.next;
        		curr = curr.next;
        	}else{
        		while(curr.next != null && curr.val == curr.next.val){
        			curr = curr.next;
        		}
        		curr = curr.next;
        	}
        }
        tail.next = curr;
        return prehead.next;
    }
}
