package org.supersense.leetcode.problems.p107;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (root == null)
			return ret;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		List<Integer> clist = new LinkedList<Integer>();
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t == null) {
				ret.offerFirst(clist);
				clist = new LinkedList<Integer>();
				if (!q.isEmpty()) {
					q.add(null);
				}
			} else {
				clist.add(t.val);
				if (t.left != null)
					q.add(t.left);
				if (t.right != null)
					q.add(t.right);
			}
		}
		return ret;
    }
}
