package org.supersense.leetcode.problems.p150;

public class Solution {
    public int evalRPN(String[] tokens) {
        int[] s = new int[100000];
        int top = -1;
        for(int i = 0; i<tokens.length; i++){
        	if(isOperator(tokens[i])){
        		//System.out.println("Operator: "+tokens[i]);
        		//System.out.println("Poping num "+Integer.parseInt(s.peek()));
        		int num2 = s[top--];
        		//System.out.println("Poping num "+Integer.parseInt(s.peek()));
        		int num1 = s[top--];
        		int num = operate(num1,num2,tokens[i]);
        		s[++top] = num;
        	}
        	else{
        		s[++top] = Integer.parseInt(tokens[i]);
        	}
        }
        return s[top];
    }
    
/*    private boolean isNumeric(String str)
    {
        return str.matches("[-]?\\d+");
    }
    */
    
/*	private boolean isOperator(String str) {
		return str.matches("[\\+\\-\\*\\/]");
	}*/
    
    private boolean isOperator(String str){
    	return (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"));
    }
    
    private int operate(int num1, int num2, String op){
    	switch (op) {
        case "+": return num1+num2;
        case "-": return num1-num2;
        case "*": return num1*num2;
        default: return num1/num2;
        }
    }
}
