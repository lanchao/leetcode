package org.supersense.leetcode.problems.p68;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> fullJustify(String[] words, int L) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < L; ++i) {
			sb.append(" ");
		}
		final String pads = sb.toString();
		final List<String> strs = new ArrayList<>();
		for (int i = 0, sum = 0, j = 0; i < words.length; i = j) {
			for (j = i + 1, sum = words[i].length(); j < words.length
					&& sum + j - i + words[j].length() <= L; ++j) {
				sum += words[j].length();
			}

			final StringBuilder l = new StringBuilder();
			final int n = j - 1 - i;
			final int m = (j == words.length || 0 == n) ? 1 : ((L - sum) / n);
			final int b = (j == words.length) ? 0 : (L - sum - m * n);

			for (int k = i; k < j - 1; ++k) {
				l.append(words[k]);
				l.append(pads.substring(0, (k - i < b) ? (m + 1) : m));
			}

			l.append(words[j - 1]);
			if (j == words.length || 0 == n) {
				l.append(pads.substring(0, L - sum - n));
			}

			strs.add(l.toString());
		}

		return strs;
	}
}
