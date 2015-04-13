package org.supersense.leetcode.problems.p88;

public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		int l = n;
		for (int j = 0; j < n; j++) {
			int v = B[j];
			insert(A, v, l);
			l++;
		}
	}

	private void insert(int[] A, int v, int e) {
		int idx = 0;
		for (idx = 0; idx < e; idx++) {
			if (A[idx] > v)
				break;
		}
		for (int i = e; i >= idx; i--) {
			A[i] = A[i - 1];
		}
		A[idx] = v;
	}
}
