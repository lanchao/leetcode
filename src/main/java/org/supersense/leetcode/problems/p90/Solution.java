package org.supersense.leetcode.problems.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i <= num.length; i++) {
			dfs(num, ret, new LinkedList<Integer>(), num.length, 0, i);
		}
		return ret;
	}

	private void dfs(int[] S, List<List<Integer>> ret, List<Integer> curr,
			int n, int b, int k) {
		if (k == 0) {
			ret.add(curr);
		}

		if (b > n) {
			return;
		}
		for (int i = b; i < n; i++) {
			List<Integer> nr = new LinkedList<Integer>();
			nr.addAll(curr);
			nr.add(S[i]);
			dfs(S, ret, nr, n, i + 1, k - 1);
			while (i + 1 < S.length && S[i + 1] == S[i]) i++;
		}
	}
}