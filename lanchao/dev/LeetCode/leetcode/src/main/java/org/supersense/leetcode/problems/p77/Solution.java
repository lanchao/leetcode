package org.supersense.leetcode.problems.p77;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        dfs(ret, new LinkedList<Integer>(), n, 1, k);
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, List<Integer> curr, int n, int b, int k) {
    	if( k == 0){
    		ret.add(curr);
    	}
    	if(b > n){
    		return;
    	}
    	for(int i = b; i <= n; i++){
    		List<Integer> nr = new LinkedList<Integer>();
    		nr.addAll(curr);
    		nr.add(i);
    		dfs(ret, nr, n, i + 1, k - 1);
    	}
    }
}
