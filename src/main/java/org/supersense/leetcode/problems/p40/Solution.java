package org.supersense.leetcode.problems.p40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> curr = new LinkedList<Integer>();
        Arrays.sort(candidates);
        dfs(ret, curr, candidates, 0, target);
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, List<Integer> curr, int[] cand, int beginidx, int target) {
    	if(target == 0){
    		ret.add(curr);
    		return;
    	}
    	if(target < 0 || beginidx >= cand.length){
    		return;
    	}
    	if(cand[beginidx] <= target){
    		List<Integer> nlist = new LinkedList<Integer>();
    		nlist.addAll(curr);
    		nlist.add(cand[beginidx]);
    		dfs(ret, nlist, cand, beginidx + 1, target - cand[beginidx]);
    	}
    	int i = 1;
    	while(beginidx + i < cand.length && cand[beginidx] == cand[beginidx + i]){
    		i ++;
    	}
    	dfs(ret, curr, cand, beginidx + i, target);
    }
}
