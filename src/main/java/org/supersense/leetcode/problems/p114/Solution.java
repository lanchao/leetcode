package org.supersense.leetcode.problems.p114;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
	public void flatten(TreeNode root) {
		preOrderVisiting(root);
	}

	private TreeNode preOrderVisiting(TreeNode root) {
		if (root == null)
			return null;
		TreeNode leftlist = preOrderVisiting(root.left);
		TreeNode rightlist = preOrderVisiting(root.right);
		root.left = null;
		TreeNode curr = leftlist;
		if (curr != null) {
			while (curr.right != null) {
				curr = curr.right;
			}
			curr.right = rightlist;
			root.right = leftlist;
		}else{
			root.right = rightlist;
		}
		return root;
	}
}
