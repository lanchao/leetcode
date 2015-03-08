package org.supersense.leetcode.problems.p152;

public class Solution {
    public int maxProduct(int[] A) {
        int max = A[0];
        int min = A[0];
        int base = A[0];
        for(int i = 1; i < A.length; i++){
        	if(A[i]>0){
        		max = Math.max(max * A[i], A[i]);
        		min = Math.min(min * A[i], A[i]);
        	}else{
        		int tmp = max;
        		max = Math.max(min * A[i], A[i]);
        		min = Math.min(tmp * A[i], A[i]);
        	}
        	if(max > base){
        		base = max;
        	}
        }
        return base;
    }
}
