package org.supersense.leetcode.problems.p124;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
	private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        visit(root);
        return max;
    }
    private int visit(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	int lmax = Math.max(0, visit(root.left));
    	int rmax = Math.max(0, visit(root.right));
    	
    	int val = root.val + lmax + rmax;
    	max = Math.max(max, val);
    	return root.val + Math.max(lmax, rmax);
    }
}
