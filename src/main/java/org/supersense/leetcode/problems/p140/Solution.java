package org.supersense.leetcode.problems.p140;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		/*boolean[] dp = dpprocess(s, wordDict);
		List<String> ret = new LinkedList<String>();

		if (dp[s.length()]) {
			dfs(ret, "", dp, s, 0, wordDict);
		}

		
		return ret;*/
		return dfsWithOutDP(s, wordDict);
	}

	private void dfs(List<String> ret, String pre, boolean dp[], String s,
			int idx, Set<String> dict) {
		if (idx == s.length()) {
			String ans = pre.trim();
			if (ans.length() != 0) {
				ret.add(ans);
			}
		}
		for (int i = idx + 1; i <= s.length(); i++) {
			if (dp[i]) {
				String sub = s.substring(idx, i);
				if (dict.contains(sub)) {
					dfs(ret, pre + " " + sub, dp, s, i, dict);
				}
			}
		}
	}

	private List<String> dfsWithOutDP(String s, Set<String> dict) {
		List<String> ret = new LinkedList<String>();
		if (s == null) {
			return ret;
		}
		int i = 0;
		for (i = 1; i <= s.length(); i++) {
			if (dict.contains(s.substring(0, i))) {
				break;
			}
		}
		if (i == s.length()) {
			return ret;
		}
		for (i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i + 1);
			if (dict.contains(sub)) {
				List<String> subret = dfsWithOutDP(s.substring(i + 1), dict);
				for (String ss : subret) {
					ret.add(sub + " " + ss);
				}
			}
		}
		return ret;
	}

	public boolean[] dpprocess(String s, Set<String> dict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j]) {
					String sub = s.substring(j, i);
					if (dict.contains(sub)) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp;
	}
}
