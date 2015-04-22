package org.supersense.leetcode.problems.p4;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;
		if (length % 2 != 0)
			return findkth(nums1, 0, nums1.length, nums2, 0, nums2.length,
					length / 2 + 1);
		else
			return (findkth(nums1, 0, nums1.length, nums2, 0, nums2.length,
					length / 2) + findkth(nums1, 0, nums1.length, nums2, 0,
					nums2.length, length / 2 + 1)) / 2.0;
	}

	private int findkth(int nums1[], int s1, int e1, int nums2[], int s2, int e2, int k) {
		if ((e1 - s1) > (e2 - s2))
			return findkth(nums2, s2, e2, nums1, s1, e1, k);
		if ((e1 - s1) == 0)
			return nums2[s2 + k - 1];
		if (k == 1)
			return nums1[s1] < nums2[s2] ? nums1[s1] : nums2[s2];
		int pa = k / 2 < (e1 - s1) ? k / 2 : (e1 - s1);
		int pb = k - pa;
		if (nums1[s1 + pa - 1] == nums2[s1 + pb - 1]) {
			return nums1[s1 + pa - 1];
		}
		if (nums1[s1 + pa - 1] < nums2[s2 + pb - 1]) {
			return findkth(nums1, s1 + pa, e1, nums2, s2, s2 + pb, k - pa);
		}

		else {
			return findkth(nums1, s1, s1 + pa, nums2, s2 + pb, e2, k - pb);
		}
	}
}