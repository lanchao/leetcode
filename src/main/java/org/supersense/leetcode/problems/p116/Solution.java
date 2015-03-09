package org.supersense.leetcode.problems.p116;

import java.util.LinkedList;
import java.util.Queue;
import org.supersense.leetcode.problems.utils.TreeLinkNode;

public class Solution {
    public void connect(TreeLinkNode root) {
    	if(root != null){
            Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
            queue.add(root);
            int count = 1;
            while(!queue.isEmpty()){
            	TreeLinkNode head = queue.poll();
            	for(int i = 1; i< count ;i++){
            		TreeLinkNode t = queue.poll();
            		head.next = t;
            		if(head.left != null){
            			queue.add(head.left);
            		}
            		if(head.right != null){
            			queue.add(head.right);
            		}
            		head = t;
            	}
            	head.next = null;
            	if(head.left != null){
        			queue.add(head.left);
        		}
        		if(head.right != null){
        			queue.add(head.right);
        		}
            	count *= 2;
            }
    	}
    }
}
