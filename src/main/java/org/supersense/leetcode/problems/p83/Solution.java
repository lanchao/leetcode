package org.supersense.leetcode.problems.p83;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while(curr != null){
        	if(curr.val != pre.val){
        		pre.next = curr;
        		pre = curr;
        	}
        	curr = curr.next;
        }
        pre.next = null;
        return head;
    }
}
