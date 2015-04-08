package org.supersense.leetcode.problems.p64;

public class Solution {
	public int minPathSum(int[][] grid) {
		int[][] A = new int[grid.length][grid[0].length];
		A[0][0] = grid[0][0];
		for (int i = 1; i < grid.length; i++) {
			A[i][0] = grid[i][0] + A[i - 1][0];
		}
		for (int j = 1; j < grid[0].length; j++) {
			A[0][j] = grid[0][j] + A[0][j - 1];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				A[i][j] = Math.min(A[i - 1][j], A[i][j - 1]) + grid[i][j];
			}
		}
		return A[grid.length - 1][grid[0].length - 1];
	}
}
