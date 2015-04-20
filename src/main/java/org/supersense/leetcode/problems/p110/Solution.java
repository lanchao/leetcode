package org.supersense.leetcode.problems.p110;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        if(Math.abs(height(root.left, 2) - height(root.right, 2)) <= 1){
        	return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
    public int height(TreeNode root, int heg){
    	if(root == null)
    		return heg - 1;
    	int lheg = height(root.left, heg + 1);
    	int rheg = height(root.right, heg + 1);
    	return lheg > rheg ? lheg:rheg;
    }
}
