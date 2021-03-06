package org.supersense.leetcode.problems.p102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (root == null)
			return ret;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		List<Integer> clist = new LinkedList<Integer>();
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t == null) {
				ret.add(clist);
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
/*
 * public class Solution { public List<List<Integer>> levelOrder(TreeNode root)
 * { List<List<Integer>> ret = new LinkedList<List<Integer>>(); if (root ==
 * null) return ret; Queue<Pair> q = new LinkedList<Pair>(); Pair p = new
 * Pair(root, 0); q.add(p); int depth = -1; List<Integer> clist = null; while
 * (!q.isEmpty()) { Pair t = q.poll(); if (t.depth != depth) { if (clist !=
 * null) ret.add(clist); List<Integer> nlist = new LinkedList<Integer>(); clist
 * = nlist; } clist.add(t.t.val); depth = t.depth; if (t.t.left != null) { Pair
 * l = new Pair(t.t.left, t.depth + 1); q.add(l); } if (t.t.right != null) {
 * Pair r = new Pair(t.t.right, t.depth + 1); q.add(r); } } ret.add(clist);
 * return ret; }
 * 
 * class Pair { TreeNode t; int depth;
 * 
 * Pair(TreeNode t, int depth) { this.t = t; this.depth = depth; } } }
 */