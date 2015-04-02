package org.supersense.leetcode.problems.p59;

public class Solution {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int xlength = n;
		int ylength = n;
		int step = xlength * ylength;
		int xstep = 1, xidx = -1, ystep = 1, yidx = 0;
		boolean hmove = true;
		int count = 1;
		while (step > 0) {
			if (hmove) {
				ylength--;
				for (int i = 0; i < xlength; i++) {
					xidx += xstep;
					matrix[yidx][xidx] = count++;
					step--;
				}
				xstep *= -1;
				hmove = false;
			} else {
				xlength--;
				for (int i = 0; i < ylength; i++) {
					yidx += ystep;
					matrix[yidx][xidx] = count++;
					step--;
				}
				ystep *= -1;
				hmove = true;
			}
		}
		return matrix;
	}
}
