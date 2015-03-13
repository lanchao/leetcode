package org.supersense.leetcode.problems.p23;

import java.util.List;
import org.supersense.leetcode.problems.utils.ListNode;

public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0){
        	return null;
        }
        int mid = lists.size()/2;
        return merge(lists.subList(0, mid), lists.subList(mid, lists.size()));
    }

    private ListNode merge(List<ListNode> l1, List<ListNode> l2){
    	if((l1 == null || l1.size() == 0) && (l2 == null || l2.size() == 0))
    		return null;
    	if(l1 != null && l1.size() == 0 && l2 !=null && l2.size() == 1)
    		return l2.get(0);
    	if(l1 != null && l1.size() == 1&& l2 !=null && l2.size() == 0)
    		return l1.get(0);
    	if(l1 != null && l1.size() == 1&& l2 !=null && l2.size() == 1)
    		return mergeTwoLists(l1.get(0), l2.get(0));
    	int mid1 = l1.size()/2;
    	int mid2 = l2.size()/2;    	
    	return mergeTwoLists(merge(l1.subList(0, mid1), l1.subList(mid1, l1.size())), merge(l2.subList(0, mid2), l2.subList(mid2, l2.size())));
    }
    
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				curr.next = l1;
				l1 = l1.next;
			}else{
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if(l1 == null){
			curr.next = l2;
		}else{
			curr.next = l1;
		}
		return head.next;
	}
}
