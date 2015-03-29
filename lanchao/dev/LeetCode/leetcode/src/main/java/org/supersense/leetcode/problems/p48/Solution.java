package org.supersense.leetcode.problems.p48;

public class Solution {
	public void rotate(int [][] matrix){
		int length = matrix.length;
		int h1 = 0;
		int h2 = matrix.length - 1;
		while(length > 1){
			for(int j = h1; j < h2; j++){
				int tmp = matrix[h1][j];
				matrix[h1][j] = matrix[matrix.length - j - 1][h1];
				matrix[matrix.length - j - 1][h1] = matrix[h2][matrix.length - j - 1];
				matrix[h2][matrix.length - j - 1] = matrix[j][h2];
				matrix[j][h2] = tmp;
			}
			length-=2;
			h1++;
			h2--;
		}
	}
}
