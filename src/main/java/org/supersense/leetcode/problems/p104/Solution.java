package org.supersense.leetcode.problems.p104;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
	private int currdepth = 0;

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		inorder(root, 1);
		return currdepth;
	}

	private void inorder(TreeNode root, int depth) {
		if (root == null)
			return;
		if (depth > currdepth) {
			currdepth = depth;
		}
		inorder(root.left, depth + 1);
		inorder(root.right, depth + 1);
	}
}
