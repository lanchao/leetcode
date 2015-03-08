package org.supersense.leetcode.problems.p95;

import java.util.List;

public class Test {

	public static void main(String[] args) {

		Solution s = new Solution();
		List<TreeNode> l = s.generateTrees(0);
		System.out.println(l.size());
		for(TreeNode t : l){
			if(t != null)
			t.printTree();
		}
	}

}
