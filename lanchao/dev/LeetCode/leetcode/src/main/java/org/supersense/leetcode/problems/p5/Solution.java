package org.supersense.leetcode.problems.p5;

public class Solution {
	private int begin = 0;
	private int end = 0;

	public String longestPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			findPalindrome(s, i, i);
			findPalindrome(s, i, i + 1);
		}
		return s.substring(begin, end + 1);
	}

	private void findPalindrome(String s, int i, int j) {
		char[] cc = s.toCharArray();
		while (i >= 0 && j < s.length()) {
			if (cc[i] == cc[j]) {
				if ((j - i) > (end - begin)) {
					begin = i;
					end = j;
				}
				i--;
				j++;
			} else {
				break;
			}
		}
	}
}
