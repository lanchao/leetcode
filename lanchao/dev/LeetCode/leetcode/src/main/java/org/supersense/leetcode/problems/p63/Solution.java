package org.supersense.leetcode.problems.p63;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] A = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0) {
				A[i][0] = 1;
			} else {
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 0) {
				A[0][i] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					A[i][j] = A[i - 1][j] + A[i][j - 1];
				} else {
					A[i][j] = 0;
				}
			}
		}
		return A[m - 1][n - 1];
	}
}
