package org.supersense.leetcode.problems.p78;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		Arrays.sort(S);
		for (int i = 0; i <= S.length; i++) {
			dfs(S, ret, new LinkedList<Integer>(), S.length, 0, i);
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
		}
	}
}
