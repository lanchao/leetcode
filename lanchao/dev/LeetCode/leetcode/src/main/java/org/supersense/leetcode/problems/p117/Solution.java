package org.supersense.leetcode.problems.p117;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void connect(TreeLinkNode root) {
    	if(root != null){
            Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
            queue.add(root);
            int count = 1;
            while(!queue.isEmpty()){
            	TreeLinkNode head = queue.poll();
            	int cc = 0;
            	for(int i = 1; i< count ;i++){
            		TreeLinkNode t = queue.poll();
            		head.next = t;
            		if(head.left != null){
            			queue.add(head.left);
            			cc++;
            		}
            		if(head.right != null){
            			queue.add(head.right);
            			cc++;
            		}
            		head = t;
            	}
            	head.next = null;
            	if(head.left != null){
        			queue.add(head.left);
        			cc++;
        		}
        		if(head.right != null){
        			queue.add(head.right);
        			cc++;
        		}
            	count = cc;
            }
    	}
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}