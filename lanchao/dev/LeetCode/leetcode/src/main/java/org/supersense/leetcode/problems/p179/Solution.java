package org.supersense.leetcode.problems.p179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	public String largestNumber(int[] num) {

		ArrayList<String> sl = new ArrayList<String>();
		for (int n : num) {
			sl.add(Integer.toString(n));
		}

		Collections.sort(sl, new StringCompare());
		StringBuilder sb = new StringBuilder();
		for (String s : sl) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() != 1) {
			sb.delete(0, 1);
		}
		return sb.toString();
	}

	class StringCompare implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {

			String s1 = o1, s2 = o2;
			while (s1.length() != s2.length()) {
				if (s1.length() > s2.length()) {
					String sub = s1.substring(0, s2.length());
					if (!sub.equals(s2)) {
						return s2.compareTo(sub);
					}
					s1 = s1.substring(s2.length());
				} else {
					String sub = s2.substring(0, s1.length());
					if (!sub.equals(s1)) {
						return sub.compareTo(s1);
					}
					s2 = s2.substring(s1.length());
				}
			}
			return s2.compareTo(s1);
		}
	}

}
