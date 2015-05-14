package org.supersense.leetcode.problems.p199;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
        	return ret;
        }
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()&&queue.peek()!=null){
        	TreeNode node = queue.poll();
        	if(node.left != null){
        		queue.add(node.left);
        	}
        	if(node.right != null){
        		queue.add(node.right);
        	}
        	if(queue.peek() == null){
        		ret.add(node.val);
        		queue.poll();
        		queue.add(null);
        	}
        }
        return ret;
    }
}
