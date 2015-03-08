package org.supersense.leetcode.problems.p95;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<TreeNode> generateTrees(int n) {
		//return recursiveGenerateTrees(1, n);
		return dpGenerateTrees(n);
	}

	private List<TreeNode> recursiveGenerateTrees(int s, int e) {
		List<TreeNode> ret = new LinkedList<TreeNode>();
		if (s > e) {
			ret.add(null);
			return ret;
		}
		for (int i = s; i <= e; i++) {
			List<TreeNode> leftNodes = recursiveGenerateTrees(s, i - 1);
			List<TreeNode> rightNodes = recursiveGenerateTrees(i + 1, e);
			for (TreeNode ln : leftNodes) {
				for (TreeNode rn : rightNodes) {
					TreeNode n = new TreeNode(i);
					n.left = ln;
					n.right = rn;
					ret.add(n);
				}
			}
		}
		return ret;
	}

	private List<TreeNode> dpGenerateTrees(int n) {
		List<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.add(null);
		for (int i = 1; i <= n; i++) {
			List<TreeNode> newnodes = new LinkedList<TreeNode>();
			for (TreeNode old : nodes) {
				TreeNode ltn = new TreeNode(i);
				ltn.left = old;
				newnodes.add(ltn);

				if (old != null) {
					TreeNode current = old;
					while (current.right != null) {
						TreeNode rtn = new TreeNode(i);
						TreeNode oldright = current.right;
						current.right = rtn;
						rtn.left = oldright;
						TreeNode newTree = cloneTree(old);
						newnodes.add(newTree);
						current.right = oldright;
						current = oldright;
					}
					TreeNode rtn = new TreeNode(i);
					current.right = rtn;
					TreeNode newTree = cloneTree(old);
					newnodes.add(newTree);
					current.right = null;
				}
			}
			nodes = newnodes;
		}
		return nodes;
	}

	private TreeNode cloneTree(TreeNode tn) {
		if (tn == null) {
			return null;
		}
		TreeNode n = new TreeNode(tn.val);
		n.left = cloneTree(tn.left);
		n.right = cloneTree(tn.right);
		return n;
	}
}
