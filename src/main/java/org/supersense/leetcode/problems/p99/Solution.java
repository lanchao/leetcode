package org.supersense.leetcode.problems.p99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
	
    public void recoverTree1(TreeNode root) {
    	if(root == null)
    		return;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	inorder(root, s);
    	if(s.size() < 2){
    		return;
    	}
    	TreeNode first = null;
    	TreeNode second = null;
    	TreeNode pre = s.pop();
    	while(!s.isEmpty()){
    		TreeNode now = s.pop();
    		if(pre.val < now.val){
    			if(first == null){
    				first = pre;
    			}
    			second = now;
    		}
    		pre = now;
    	}
    	if(first != null && second != null){
    		int tmp = first.val;
        	first.val = second.val;
        	second.val = tmp;
    	}
    }
    
    private void inorder(TreeNode root, Stack<TreeNode> s) {
    	if(root == null)
    		return;
    	inorder(root.left, s);
    	s.push(root);
    	inorder(root.right, s);
    }
    
    public void recoverTree(TreeNode root) {
    	inorderMorrisTraversal(root);
    }
    private void inorderMorrisTraversal(TreeNode root){
    	TreeNode curr = root, prev = null;
    	TreeNode first = null;
    	TreeNode second = null;
    	TreeNode pre = null;
    	
    	while(curr != null){
    		if(curr.left == null){
    			if(pre != null && pre.val > curr.val){
        			if(first == null){
        				first = pre;
        			}
        			second = curr;
        		}
    			pre = curr;
        		curr = curr.right;
    		}else{
    			prev = curr.left;
    			while(prev.right != null && prev.right != curr){
    				prev = prev.right;
    			}
    			if(prev.right == null){
    				prev.right = curr;
    				curr = curr.left;
    			}else{
    				prev.right = null;
    				if(pre.val > curr.val){
            			if(first == null){
            				first = pre;
            			}
            			second = curr;
            		}
    				pre = curr;
    				curr = curr.right;
    			}
    		}
    	}
    	if(first != null && second != null){
    		int tmp = first.val;
        	first.val = second.val;
        	second.val = tmp;
    	}
    }
}
