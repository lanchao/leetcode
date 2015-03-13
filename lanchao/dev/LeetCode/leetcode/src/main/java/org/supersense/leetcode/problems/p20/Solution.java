package org.supersense.leetcode.problems.p20;

public class Solution {
    public boolean isValid(String s) {
        char[] cc = s.toCharArray();
        char[] stack = new char[10000];
        int top = -1;
        for(char c : cc){
        	if(c == '(' || c == '[' || c == '{'){
        		stack[++top] = c;
        	}else if(c == ')'){
        		if(top == -1 || stack[top--] != '('){
        			return false;
        		}
        	}else if(c == ']'){
        		if(top == -1 || stack[top--] != '['){
        			return false;
        		}
        	}else if(c == '}'){
        		if(top == -1 || stack[top--] != '{'){
        			return false;
        		}
        	}
        }
        if(top == -1){
        	return true;
        }else{
        	return false;
        }
    }
}
