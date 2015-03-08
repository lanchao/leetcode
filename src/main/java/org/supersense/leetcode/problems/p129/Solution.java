package org.supersense.leetcode.problems.p129;

public class Solution {

	private int sum = 0;
	public int sumNumbers(TreeNode root) {
		sum = 0;
		TreeNode current = root;
		preorderVisit(current);
		return sum;
	}
	
	private void preorderVisit(TreeNode root){
		if(root == null){
			return;
		}
		if(root.left == null&&root.right == null){
			this.sum += root.val;
			return;
		}
		if(root.left != null){
			root.left.val += (root.val * 10);
			preorderVisit(root.left);
		}
		if(root.right != null){
			root.right.val += (root.val * 10);
			preorderVisit(root.right);
		}
	}
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
