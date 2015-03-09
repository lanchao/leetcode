package org.supersense.leetcode.problems.p112;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		return nonRecursive(root, sum);
	}

	private boolean recursive(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (root.val == sum)
				return true;
			else
				return false;
		}
		boolean ltrue = false, rtrue = false;
		if (root.left != null) {
			root.left.val += root.val;
			ltrue = recursive(root.left, sum);
		}
		if (root.right != null) {
			root.right.val += root.val;
			rtrue = recursive(root.right, sum);
		}
		return ltrue || rtrue;
	}

	private boolean nonRecursive(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		TreeNode[] stack = new TreeNode[10000];
		int top = -1;
		stack[++top] = root;
		while (top != -1) {
			TreeNode curr = stack[top--];
			if (curr.left == null && curr.right == null) {
				if (curr.val == sum)
					return true;
				else
					continue;
			}
			if (curr.left != null) {
				curr.left.val += curr.val;
				stack[++top] = curr.left;
			}
			if (curr.right != null) {
				curr.right.val += curr.val;
				stack[++top] = curr.right;
			}
		}
		return false;
	}
}
