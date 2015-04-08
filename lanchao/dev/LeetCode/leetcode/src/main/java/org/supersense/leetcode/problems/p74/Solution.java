package org.supersense.leetcode.problems.p74;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int r = binarysearchrow(matrix, 0, matrix.length - 1, target);
		return binarysearch(matrix[r], 0, matrix[0].length - 1, target);
	}

	private int binarysearchrow(int[][] matrix, int s, int e, int target) {
		int mid = (s + e) / 2;
		if (matrix[mid][0] == target) {
			return mid;
		}
		if (s >= e) {
			if(matrix[mid][0] > target && mid > 0){
				return mid - 1;
			}else{
				return mid;
			}
		}
		if(matrix[mid][0] > target){
			return binarysearchrow(matrix, s, mid - 1, target);
		}
		return binarysearchrow(matrix, mid + 1, e, target);
	}
	
	private boolean binarysearch(int[] matrix, int s, int e, int target){
		int mid = (s+e)/2;
		if(matrix[mid] == target){
			return true;
		}
		if(s >=e){
			return false;
		}
		if(matrix[mid] > target){
			return binarysearch(matrix, s, mid - 1, target);
		}
		return binarysearch(matrix, mid + 1, e, target);
	}
}
