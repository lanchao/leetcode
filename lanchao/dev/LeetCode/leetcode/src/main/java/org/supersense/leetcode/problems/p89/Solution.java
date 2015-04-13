package org.supersense.leetcode.problems.p89;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> ret = new LinkedList<Integer>();
		for (int i = 0; i < 1 << n; i++) {
			ret.add(i ^ i >> 1);
		}
		return ret;
	}
}
