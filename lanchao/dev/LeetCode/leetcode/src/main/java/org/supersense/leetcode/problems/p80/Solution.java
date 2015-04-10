package org.supersense.leetcode.problems.p80;

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0){
        	return 0;
        }
        if(A.length == 1 || A.length == 2){
        	return A.length;
        }
        int count = 2;
        int pre = A[0];
        for(int i = 2; i < A.length; i++){
        	if(A[i] != A[i -1] || (A[i] == A[i -1] && A[i] !=  pre)){
        		pre = A[i - 1];
        		A[count++] = A[i];
        	}else{
        		pre = A[i - 1];
        	}
        	
        }
        return count;
    }
}
