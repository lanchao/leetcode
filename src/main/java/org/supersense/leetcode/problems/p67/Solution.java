package org.supersense.leetcode.problems.p67;

public class Solution {
    public String addBinary(String a, String b) {
        String ret = "";
        if(a.length() < b.length()){
        	String tmp = a;
        	a = b;
        	b = tmp;
        }
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int dig = 0;
        while(j >= 0){
        	int sum = (ca[i] - '0') + (cb[j] - '0') + dig;
        	dig = sum/2;
        	sum%=2;
        	ret = sum + ret;
        	i--;
        	j--;
        }
        while(i >= 0){
        	int sum = ca[i] - '0' + dig;
        	dig = sum/2;
        	sum %= 2;
        	ret = sum + ret;
        	i--;
        }
        if(dig != 0){
        	ret = dig + ret;
        }
        return ret;
    }
}
