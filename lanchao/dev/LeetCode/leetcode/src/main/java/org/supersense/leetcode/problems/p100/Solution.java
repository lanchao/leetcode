package org.supersense.leetcode.problems.p100;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q)
        	return true;
        if(p != null && q != null && p.val == q.val){
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
