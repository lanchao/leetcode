package problems.p143;

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
        	return;
        }
        ListNode secondHalf = dividList(head);
        ListNode preNode = null;
        ListNode curNode = secondHalf;
        while(secondHalf != null){
        	curNode = secondHalf.next;
        	secondHalf.next = preNode;
        	preNode = secondHalf;
        	secondHalf = curNode;
        }
        secondHalf = preNode;
        
        ListNode firstHalf = head;
        while(secondHalf != null){
        	curNode = firstHalf.next;
        	firstHalf.next = secondHalf;
        	firstHalf = secondHalf;
        	secondHalf = curNode;
        }
    }
    
    private ListNode dividList(ListNode head){
    	ListNode head1 = head;
    	ListNode head2 = head.next;
    	
    	while(head2!=null && head2.next!=null){
    		head1 = head1.next;
    		head2 = (head2.next).next;
    	}
    	head2 = head1.next;
    	head1.next = null;
    	return head2;
    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}