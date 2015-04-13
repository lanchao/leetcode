package org.supersense.leetcode.problems.p81;

public class Solution {
    public boolean search(int[] A, int target) {
        return binarysearch(A, target);
    }
    
    private boolean binarysearch(int[] A, int target){
    	int b = 0;
    	int e = A.length - 1;

    	while(b <= e){
    		int mid = (b + e) / 2;
    		if(A[mid] == target){
        		return true;
        	}else if(A[b] == A[mid]){
    			b++;
    		}else if(A[e] == A[mid]){
    			e--;
    		}else if(A[b] <= A[mid]){
        		if(target >= A[b] && target < A[mid]){
        			e = mid - 1;
        		}else{
        			b = mid + 1;
        		}
        	}else{
        		if(target > A[mid] && target <= A[e]){
        			b = mid + 1;
        		}else{
        			e = mid - 1;
        		}
        	}
    	}
    	return false;
    }
}
