package org.supersense.leetcode.problems.p75;

public class Solution {
    public void sortColors(int[] A) {
    	int k = 3;
    	int[] P = new int[k];
    	for(int i = 0; i < A.length; i++){
    		int t = A[i];
    		for(int j = k -1; j >= t; j--){
    			A[P[j]++] = j;
    		}
    	}
    }
}
