package org.supersense.leetcode.problems.p120;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle != null && triangle.isEmpty()) {
			return 0;
		}
		List<Integer> pre = new ArrayList<Integer>();
		pre.addAll(triangle.get(0));
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> curr = new ArrayList<Integer>();
			for (int j = 0; j < triangle.get(i).size(); j++) {
				int min = Integer.MAX_VALUE;
				if(j - 1 >= 0){
					min = pre.get(j-1);
				}
				if(j < pre.size()){
					if(min > pre.get(j)){
						min = pre.get(j);
					}
				}
				curr.add(min+triangle.get(i).get(j));
			}
			pre = curr;
		}
		int min = Integer.MAX_VALUE;
		for(Integer i : pre){
			if(min > i){
				min = i;
			}
		}
		return min;
	}
}
