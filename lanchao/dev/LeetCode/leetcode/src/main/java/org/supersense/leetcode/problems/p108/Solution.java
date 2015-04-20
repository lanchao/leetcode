package org.supersense.leetcode.problems.p108;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return buildTree(num, 0, num.length - 1);
    }
    private TreeNode buildTree(int[] num, int begin, int end){
    	if(begin > end)
    		return null;
    	int mid = begin + (end - begin)/ 2;
    	TreeNode t = new TreeNode(num[mid]);
    	t.left = buildTree(num, begin, mid - 1);
    	t.right = buildTree(num, mid + 1, end);
    	return t;
    }
}
