package org.supersense.leetcode.problems.p32;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
    	if(s == null || s.isEmpty()){
    		return 0;
    	}
        Stack<Integer> sti = new Stack<Integer>();
        char[] cs = s.toCharArray();
        int curr = 0;
        int max = 0;
        int tail = -1;
        for(int i = 0; i< cs.length; i++){
        	if(cs[i] == '('){
        		sti.push(i);
        	}else{
        		if(sti.isEmpty()){
        			tail = i;
        		}else{
        			sti.pop();
        			if(sti.isEmpty()){
        				curr = i - tail;
        			}else{
        				curr = i - sti.peek();
        			}
        		}
        		if(max < curr){
    				max = curr;
    			}
        	}
        }
        return max;
    }
}
