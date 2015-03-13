package org.supersense.leetcode.problems.p24;

import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode pre = newhead;
        ListNode curr = head;
        while(curr != null && curr.next != null){
        		ListNode next = curr.next;
        		curr.next = next.next;
        		next.next = curr;
        		pre.next = next;
        		pre = pre.next.next;
        		curr = pre.next;
        }
        return newhead.next;
    }
}
