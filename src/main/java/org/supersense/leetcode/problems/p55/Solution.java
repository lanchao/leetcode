package org.supersense.leetcode.problems.p55;

public class Solution {
    public boolean canJump(int[] A) {
    	int jump = A[0];
    	for(int i = 0; i < A.length; i++){
    		if(i > jump){
    			return false;
    		}
    		jump = jump > i + A[i] ? jump : i + A[i];
    	}
    	return true;
    }
}
