package problems.p95;

public class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; left = null; right = null; }
	 
	 public void printTree() {
		 firstOrder(this);
		 System.out.println();
	 }
	 
	 public void firstOrder (TreeNode n) {
		 if(n.left != null){
			 firstOrder(n.left);
		 }
		 System.out.print(n.val+" ");
		 if(n.right != null){
			 firstOrder(n.right);
		 }
	 }
}
