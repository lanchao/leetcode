package org.supersense.leetcode.problems.p101;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
    	if(root == null)
    		return true;
    	return symmetric(root.left, root.right);
    }
    private boolean symmetric(TreeNode left, TreeNode right){
    	if(left == null && right == null)
    		return true;
    	if(left != null && right != null && left.val == right.val){
    		return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    	}
    	return false;
    }
}
