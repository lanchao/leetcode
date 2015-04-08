package org.supersense.leetcode.problems.p73;

public class Solution {
	public void setZeroes(int[][] matrix) {
		int zidx = -1;
		for (int i = 0; i < matrix.length; i++) {
			if (zidx >= 0)
				break;
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					zidx = i;
					break;
				}
			}
		}
		if (zidx == -1)
			return;
		for (int i = zidx + 1; i < matrix.length; i++) {
			boolean zero = false;
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == 0) {
					matrix[zidx][j] = 0;
					zero = true;
				}
			}
			if (zero) {
				for (int z = 0; z < matrix[0].length; z++) {
					matrix[i][z] = 0;
				}
			}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[zidx][j] == 0) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
			matrix[zidx][j] = 0;
		}
	}
}