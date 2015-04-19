package org.supersense.leetcode.problems.p98;

import java.util.Stack;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        //return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    	if(root == null)
    		return true;
    	Stack<Integer> s = new Stack<Integer>();
    	inorder(root, s);
    	int i = s.pop();
    	while(!s.isEmpty()){
    		int j = s.pop();
    		if(i <= j)
    			return false;
    		i = j;
    	}
    	return true;
    }
    
    private void inorder(TreeNode root, Stack<Integer> s) {
    	if(root == null)
    		return;
    	inorder(root.left, s);
    	s.push(root.val);
    	inorder(root.right, s);
    }
    private boolean dfs(TreeNode root, long left, long right) {
    	if(root == null)
    		return true;
    	if(root.val >= left || root.val <= right)
    		return false;
    	if(dfs(root.left, Math.min(left,  root.val), right)){
    		return dfs(root.right, left, Math.max(right, root.val));
    	}
    	return false;
    }
}
