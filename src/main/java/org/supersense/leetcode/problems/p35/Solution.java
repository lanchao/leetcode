package org.supersense.leetcode.problems.p35;

public class Solution {
    public int searchInsert(int[] A, int target) {
        return binarysearch(A, 0, A.length - 1, target);
    }
    
    private int binarysearch(int[] A, int begin, int end, int target){
    	int mid = (begin+end)/2;
    	if(begin >= end){
    		if(A[mid] >= target){
    			return mid;
    		}	
    		else
    			return mid + 1;
    	}
    	
    	if(A[mid] == target){
    		return mid;
    	}else if(A[mid] > target){
    		return binarysearch(A, begin, mid-1, target);
    	}else{
    		return binarysearch(A, mid+1, end, target);
    	}
    }
}
