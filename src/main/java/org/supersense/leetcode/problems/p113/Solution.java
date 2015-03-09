package org.supersense.leetcode.problems.p113;

import java.util.LinkedList;
import java.util.List;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        recursive(root, ret, new LinkedList<Integer>(), 0, sum);
        return ret;
    }
    
	private void recursive(TreeNode root, List<List<Integer>> ret, List<Integer> plist, int psum, int sum) {
		if (root == null) {
			return;
		}
		List<Integer> newlist = new LinkedList<Integer>();
		newlist.addAll(plist);
		newlist.add(root.val);
		if (root.left == null && root.right == null) {
			if ((psum + root.val) == sum){
				ret.add(newlist);
			}
			else
				return;
		}
		if (root.left != null) {
			recursive(root.left, ret, newlist, (psum+root.val), sum);
		}
		if (root.right != null) {
			recursive(root.right, ret, newlist, (psum+root.val), sum);
		}
	}
}
