package org.supersense.leetcode.problems.p22;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private List<String> ret = new LinkedList<String>();
    public List<String> generateParenthesis(int n) {
        ret.clear();
        dfs("", n, 0, 0);
        return ret;
    }
    
    private void dfs(String ps, int n, int ln, int rn){
    	if(n == 0){
    		return;
    	}
    	if(rn == n){
    		ret.add(ps);
    	}
    	if(ln < n){
    	   	String nls = ps+"(";
        	dfs(nls, n, ln +1, rn);
    	}
    	if(ln > rn){
    		String nrs = ps+")";
    		dfs(nrs, n, ln, rn+1);
    	}
    }
}
