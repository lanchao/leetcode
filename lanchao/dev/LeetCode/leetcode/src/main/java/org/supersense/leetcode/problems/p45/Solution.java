package org.supersense.leetcode.problems.p45;

public class Solution {
	public int jump(int[] nums) {
		int currFarthest = 0;
		int step = 0;
		int farthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, nums[i] + i);
			if (i == currFarthest) {
				step++;
				currFarthest = farthest;
			}
		}
		return step;
	}

	public int jump1(int[] nums) {
		int[] dp = new int[nums.length];
		int currFarthest = 0;
		int pos = 0;
		while (currFarthest != nums.length - 1) {
			if (pos + nums[pos] >= nums.length - 1) {
				return dp[pos] + 1;
			}
			int farthest = pos + nums[pos];
			if (farthest > currFarthest) {
				for (int i = currFarthest + 1; i <= farthest; i++) {
					dp[i] = dp[pos] + 1;
				}
				currFarthest = farthest;
			}
			pos++;
		}
		return dp[currFarthest];
	}
}
