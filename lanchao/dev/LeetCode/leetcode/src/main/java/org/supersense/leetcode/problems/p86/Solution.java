package org.supersense.leetcode.problems.p86;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(0);
        ListNode tail1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode tail2 = head2;
        while(head != null){
        	if(head.val < x){
        		tail1.next = head;
        		tail1 = tail1.next;
        	}else{
        		tail2.next = head;
        		tail2 = tail2.next;
        	}
    		head = head.next;
        }
        tail2.next = null;
        tail1.next = head2.next;
        return head1.next;
    }
}
