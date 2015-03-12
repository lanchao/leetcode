package org.supersense.leetcode.problems.p3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int prev = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] cc = s.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			if (map.containsKey(cc[i])) {
				prev = Math.max(prev, map.get(cc[i]) + 1);
			}
			max = Math.max(max, i - prev + 1);
			map.put(cc[i], i);
		}
		return max;
	}
}
