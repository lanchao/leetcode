package org.supersense.leetcode.problems.p209;

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int pre = -1, pos = 0;
		int sum = 0;
		int width = Integer.MAX_VALUE;
		while (pos < nums.length) {
			sum += nums[pos];
			while (sum >= s && pre < pos) {
				if (width > pos - pre) {
					width = pos - pre;
				}
				sum -= nums[++pre];
			}
			pos++;
		}
		if (pre == -1) {
			return 0;
		}
		return width;
	}
}
