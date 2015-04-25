package org.supersense.leetcode.problems.p10;

public class Solution {
	public boolean isMatch(String s, String p) {
		return match(s.toCharArray(), p.toCharArray(), 0, 0);
	}

	private boolean match(char[] s, char[] p, int si, int pi) {
		if (p == null || p.length == 0 || pi >= p.length) {
			return (s == null || s.length == 0 || si >= s.length);
		}
		if (s == null || s.length == 0 || si >= s.length) {
			return (p == null || p.length == 0 || pi >= p.length) || (pi < p.length - 1 && p[pi + 1] == '*' && match(s, p, si, pi + 2));
		}
		if (pi < p.length - 1 && p[pi + 1] == '*') {
			return match(s, p, si, pi + 2) || (s[si] == p[pi] || p[pi] == '.')
					&& match(s, p, si + 1, pi);
		} else {
			return (s[si] == p[pi] || p[pi] == '.')
					&& match(s, p, si + 1, pi + 1);
		}
	}
}
