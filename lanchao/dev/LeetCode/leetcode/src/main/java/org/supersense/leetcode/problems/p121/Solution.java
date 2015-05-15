package org.supersense.leetcode.problems.p121;

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int max = 0;
		int maxprof = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1] + maxprof;
			if (diff > 0) {
				maxprof = diff;
			} else {
				maxprof = 0;
			}
			if (max < maxprof) {
				max = maxprof;
			}
		}
		return max;
	}
}
