package org.supersense.leetcode.problems.p138;

import java.util.HashMap;
import java.util.Map;

import org.supersense.leetcode.problems.utils.RandomListNode;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode prehead = new RandomListNode(0);
        RandomListNode curr = head;
        RandomListNode next = prehead;

        //copy
        while(curr != null){
        	next = curr.next;
        	curr.next = new RandomListNode(curr.label);
        	curr.next.next = next;
        	curr = next;
        }
        //update random
        curr = head;
        while(curr != null){
        	if(curr.random != null){
        		curr.next.random = curr.random.next;
        	}
        	curr = curr.next.next;
        }
        
        //seperate list
        curr = head;
        next = prehead;
        while(curr != null){
        	next.next = curr.next;
        	curr.next = curr.next.next;
        	curr = curr.next;
        	next = next.next;
        }
        return prehead.next;
    }
    
    private RandomListNode copyRandomListByHashTable(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode prehead = new RandomListNode(0);
        RandomListNode dstcurr = prehead;
        RandomListNode srccurr = head;
        while(srccurr != null){
        	RandomListNode newnode = new RandomListNode(srccurr.label);
        	dstcurr.next = newnode;
        	dstcurr = newnode;
        	map.put(srccurr, newnode);
        	srccurr = srccurr.next;
        }
        srccurr = head;
        dstcurr = prehead.next;
        while(srccurr != null){
        	if(srccurr.random != null){
        		dstcurr.random = map.get(srccurr.random);
        	}
        	srccurr = srccurr.next;
        	dstcurr = dstcurr.next;
        }
        return prehead.next;
    }
}
