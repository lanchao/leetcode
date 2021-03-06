package org.supersense.leetcode.problems.p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		List<Integer> remains = new ArrayList<Integer>();
		Arrays.sort(num);
		for(int i = 0 ; i < num.length; i++){
			remains.add(num[i]);
		}
		dfs(ret, curr, remains);
		return ret;
		
	}
	
	private void dfs(List<List<Integer>> ret, List<Integer> curr, List<Integer> remains){
		if(remains.size() == 0){
			ret.add(curr);
			return;
		}
		int pre = Integer.MAX_VALUE;
		for(int i = 0; i < remains.size(); i++){
			int num = remains.get(i);
			if(num != pre){
				pre = num;
				List<Integer> nr = new ArrayList<Integer>();
				List<Integer> nc = new ArrayList<Integer>();
				nr.addAll(remains);
				nc.addAll(curr);
				nc.add(remains.get(i));
				nr.remove(i);
				dfs(ret, nc, nr);
			}
		}
	}
}
