package org.supersense.leetcode.problems.p164;

import java.util.Arrays;

public class Solution {
	public int maximumGap1(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] > max) {
				max = nums[i] - nums[i - 1];
			}
		}
		return max;
	}

	class Bucket {
		int low;
		int high;

		public Bucket() {
			low = -1;
			high = -1;
		}
	}

	public int maximumGap(int[] num) {
		if (num == null || num.length < 2) {
			return 0;
		}

		int max = num[0];
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}

		// initialize an array of buckets
		int len = (max - min) / num.length + 1;
		Bucket[] buckets = new Bucket[(max - min) / len + 1]; // project to (0 -
																// n)
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}

		// distribute every number to a bucket array
		for (int i = 0; i < num.length; i++) {
			int index = (int) ((num[i] - min) / len);

			if (buckets[index].low == -1) {
				buckets[index].low = num[i];
				buckets[index].high = num[i];
			} else {
				buckets[index].low = Math.min(buckets[index].low, num[i]);
				buckets[index].high = Math.max(buckets[index].high, num[i]);
			}
		}

		// scan buckets to find maximum gap
		int result = 0;
		int prev = buckets[0].high;
		for (int i = 1; i < buckets.length; i++) {
			if (buckets[i].low != -1) {
				result = Math.max(result, buckets[i].low - prev);
				prev = buckets[i].high;
			}

		}

		return result;
	}
}
