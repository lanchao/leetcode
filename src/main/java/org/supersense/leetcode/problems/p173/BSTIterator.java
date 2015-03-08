package problems.p173;

import java.util.Stack;

public class BSTIterator {
	private TreeNode tree = null;
	private Stack<TreeNode> s = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		tree = root;
		if(tree!=null){
			findLeftTree(tree);
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !s.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode t = s.pop();
		if (t.right != null) {
			findLeftTree(t.right);
		}
		return t.val;
	}

	private void findLeftTree(TreeNode t) {
		s.add(t);
		if (t.left != null) {
			findLeftTree(t.left);
		}
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