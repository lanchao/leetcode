package org.supersense.leetcode.problems.p30;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new LinkedList<Integer>();
		if (words == null || words.length == 0 || words[0].isEmpty() || words[0].length() * words.length > s.length()) {
			return ret;
		}
		Map<String, Integer> wordset = new HashMap<String, Integer>();
		for (String ws : words) {
			wordset.put(ws, wordset.containsKey(ws) ? wordset.get(ws) + 1 : 1);
		}
		int size = words[0].length();
		char[] sc = s.toCharArray();
		for (int i = 0; i + size * words.length <= s.length(); i++) {
			String substr = String.copyValueOf(sc, i, size);
			if (wordset.containsKey(substr)) {
				Map<String, Integer> nws = new HashMap<String, Integer>();
				nws.put(substr, nws.containsKey(substr) ? nws.get(substr) + 1
						: 1);
				for (int j = 1; j < words.length; j++) {
					String sub = String.copyValueOf(sc, i + j * size, size);
					nws.put(sub, nws.containsKey(sub) ? nws.get(sub) + 1
							: 1);
				}
				if (wordset.equals(nws)) {
					ret.add(i);
				}
			}
		}
		return ret;
	}
}
