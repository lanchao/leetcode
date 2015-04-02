package org.supersense.leetcode.problems.p60;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public String getPermutation(int n, int k){
		StringBuffer ret = new StringBuffer();
		List<Integer> l = new ArrayList<Integer>();
		int factor = 1;
		for(int i = 1; i <= n; i++){
			l.add(i);
			factor*=i;
		}
		while(n > 0){
		    factor /= n;
			int idx = (k - 1) / factor;
			System.out.println(idx);
			ret.append(l.get(idx));
			l.remove(idx);
			k = k - idx * factor;
			n--;
		}
		return ret.toString();
	}
}
