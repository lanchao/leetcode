package org.supersense.leetcode.problems.p76;

import java.util.HashMap;

public class Solution {
	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0)
			return "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			if (map.containsKey(T.charAt(i))) {
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			} else {
				map.put(T.charAt(i), 1);
			}
		}
		int left = 0;
		int count = 0;
		int minLen = S.length() + 1;
		int minStart = 0;
		for (int right = 0; right < S.length(); right++) {
			if (map.containsKey(S.charAt(right))) {
				map.put(S.charAt(right), map.get(S.charAt(right)) - 1);
				if (map.get(S.charAt(right)) >= 0) {
					count++;
				}
				while (count == T.length()) {
					if (right - left + 1 < minLen) {
						minLen = right - left + 1;
						minStart = left;
					}
					if (map.containsKey(S.charAt(left))) {
						map.put(S.charAt(left), map.get(S.charAt(left)) + 1);
						if (map.get(S.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}
		if (minLen > S.length()) {
			return "";
		}
		return S.substring(minStart, minStart + minLen);
	}

	public String minWindow1(String s, String t) {
		int[] pattern = new int[256];
		int[] match = new int[256];
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		for (char c : ct) {
			pattern[c]++;
		}
		int begin = 0, end = 0;
		while (begin < cs.length && pattern[cs[begin]] == 0) {
			begin++;
		}
		if (begin == cs.length) {
			return "";
		}
		match[cs[begin]]++;
		end = begin + 1;
		while (end < cs.length && !isMatch(match, pattern)) {
			if (pattern[cs[end]] != 0) {
				match[cs[end]]++;
			}
			end++;
		}

		if (isMatch(match, pattern)) {
			int min = end - begin;
			int mbegin = begin;

			while (end < cs.length) {

				if (cs[begin] == cs[end]) {
					begin++;
					while (begin < end && pattern[cs[begin]] == 0) {
						begin++;
					}
					// System.out.println(begin + " "+ end + " " + min + " "+
					// mbegin);
					if (end - begin + 1 < min) {
						min = end - begin + 1;
						mbegin = begin;
					}
				}
				end++;
			}

			return String.copyValueOf(cs, mbegin, min);
		}
		return "";
	}

	private boolean isMatch(int[] s, int[] t) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] != t[i])
				return false;
		}
		return true;
	}
}