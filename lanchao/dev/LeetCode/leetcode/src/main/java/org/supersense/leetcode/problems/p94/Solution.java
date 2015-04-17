package org.supersense.leetcode.problems.p94;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> ret = new LinkedList<Integer>();
        TreeNode l = root;
        while(l != null){
        	s.push(l);
        	l = l.left;
        }
        while(!s.isEmpty()){
        	TreeNode t = s.pop();
        	ret.add(t.val);
        	if(t.right != null){
        		s.push(t.right);
        		l = t.right.left;
        		while(l != null){
        			s.push(l);
        			l = l.left;
        		}
        	}
        }
        return ret;
    }
}
