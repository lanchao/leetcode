package org.supersense.leetcode.problems.p145;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> ret = new LinkedList<Integer>();
		if(root == null){
			return ret;
		}
		TreeNode left = root;
		while (left != null) {
			s.push(left);
			if (left.left == null) {
				left = left.right;
			} else {
				left = left.left;
			}
		}
		while (!s.isEmpty()) {
			TreeNode t = s.pop();
			ret.add(t.val);
			TreeNode next = null;
			if (!s.isEmpty()) {
				next = s.peek().right;
			}
			if(!s.isEmpty()&&s.peek().left == t){
				while (next != null) {
					s.push(next);
					if (next.left == null) {
						next = next.right;
					} else {
						next = next.left;
					}
				}
			}
		}
		return ret;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}