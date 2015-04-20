package org.supersense.leetcode.problems.p106;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	return build(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] postorder, int[] inorder, int posbeg, int posend,
			int inbeg, int inend) {
		if(posbeg >= 0 && posbeg > posend)
			return null;
		if (inbeg > inend)
			return null;
		TreeNode t = new TreeNode(postorder[posend]);
		int inidx = -1;
		for (inidx = inbeg; inidx <= inend; inidx++) {
			if (inorder[inidx] == postorder[posend])
				break;
		}
		t.left = build(postorder, inorder, posbeg, posbeg + (inidx - inbeg) - 1, inbeg, inidx - 1);
		t.right = build(postorder, inorder, posbeg + (inidx - inbeg), posend - 1, inidx + 1, inend);
		return t;
	}
}
