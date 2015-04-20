package org.supersense.leetcode.problems.p111;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        if(root.left == null || root.right == null){
        	return 1 + ((root.left == null) ? minDepth(root.right) : minDepth(root.left));
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
