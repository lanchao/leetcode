package problems.p144;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		TreeNode[] s = new TreeNode[10000];
		int top = -1;
		List<Integer> l = new LinkedList<Integer>();
		if(root == null){
			return l;
		}
		s[++top] = root;
		while(top != -1){
			TreeNode t = s[top--];
			l.add(new Integer(t.val));
			if(t.right != null){
				s[++top] = t.right;
			}
			if(t.left!=null){
				s[++top] = t.left;
			}
		}
		return l;
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