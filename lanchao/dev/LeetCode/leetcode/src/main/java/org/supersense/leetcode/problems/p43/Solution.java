package org.supersense.leetcode.problems.p43;

public class Solution {
    public String multiply(String num1, String num2) {
    	if(num1.length() < num2.length()){
    		String tmp = num1;
    		num1 = num2;
    		num2 = tmp;
    	}
    	char[] cs2 = num2.toCharArray();
    	String pre = "";
    	String ret = "";
    	for(int i = 0; i < cs2.length; i++){
    		String mut = mutiplyByOneDig(num1, cs2[i]);
    		ret = add(pre+"0", mut);
    		pre = ret;
    	}
    	return ret;
    }
    
    private String add(String num1, String num2) {
    	StringBuffer sb = new StringBuffer();
    	if(num1.length() < num2.length()){
    		String tmp = num1;
    		num1 = num2;
    		num2 = tmp;
    	}
    	//System.out.println(num1+" "+num2);
    	char[] cs1 = num1.toCharArray();
    	char[] cs2 = num2.toCharArray();
    	int td = 0;
    	int i = cs1.length - 1;
    	int j = cs2.length - 1;
    	while(j >= 0){
    		int dig1 = cs1[i] - '0';
    		int dig2 = cs2[j] - '0';
    		int sum = dig1 + dig2 + td;
    		td = sum / 10;
    		sum %= 10;
    		sb.insert(0, sum);
    		//System.out.println(sum);
    		i--;
    		j--;
    	}
    	while(td == 1){
    		int dig = 0;
    		if(i >= 0){
    			dig = cs1[i] - '0';
    		}
    		int sum = dig + td;
			td = 0;
			td = sum / 10;
			sum %= 10;
			sb.insert(0, sum);
			i--;
    	}
    	while(i >= 0){
    		sb.insert(0, cs1[i]);
    		i--;
    	}
    	return sb.toString();
    }
    
    private String mutiplyByOneDig(String num, char cdig){
    	if(cdig == '0'){
    		return "0";
    	}
    	StringBuffer sb = new StringBuffer();
    	char[] cnum = num.toCharArray();
    	int dig = cdig - '0';
    	int td = 0;
    	for(int i = cnum.length - 1; i >= 0; i--){
    		int n = cnum[i] - '0';
    		int mut = n * dig + td;
    		td = mut / 10;
    		mut %= 10;
    		sb.insert(0, mut);
    	}
    	if(td > 0){
    		sb.insert(0, td);
    	}
    	return sb.toString();
    }
}
