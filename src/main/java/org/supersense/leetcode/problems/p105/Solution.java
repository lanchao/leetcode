package org.supersense.leetcode.problems.p105;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode build(int[] preorder, int[] inorder, int prebeg, int preend,
			int inbeg, int inend) {
		if(prebeg > preend)
			return null;
		if (inbeg > inend)
			return null;
		TreeNode t = new TreeNode(preorder[prebeg]);
		int inidx = -1;
		for (inidx = inbeg; inidx <= inend; inidx++) {
			if (inorder[inidx] == preorder[prebeg])
				break;
		}
		t.left = build(preorder, inorder, prebeg + 1, prebeg + inidx - inbeg, inbeg, inidx - 1);
		t.right = build(preorder, inorder, prebeg + inidx - inbeg + 1, preend, inidx + 1, inend);
		return t;
	}
}
