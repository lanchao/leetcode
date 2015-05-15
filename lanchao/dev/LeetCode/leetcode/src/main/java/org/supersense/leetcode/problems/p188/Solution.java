package org.supersense.leetcode.problems.p188;

public class Solution {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		if (k > prices.length / 2) {
			int max = 0;
			for (int i = 1; i < prices.length; i++) {
				int diff = prices[i] - prices[i - 1];
				if (diff > 0) {
					max += diff;
				}
			}
			return max;
		}

		int[] hold = new int[k + 1], sell = new int[k + 1];

		for (int i = 0; i <= k; i++) {
			sell[i] = 0;
			hold[i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < prices.length; i++) {
			for (int j = k; j > 0; j--) {
				sell[j] = Math.max(sell[j], hold[j] + prices[i]);
				hold[j] = Math.max(hold[j], sell[j - 1] - prices[i]);
			}
		}
		return sell[k];
	}
}