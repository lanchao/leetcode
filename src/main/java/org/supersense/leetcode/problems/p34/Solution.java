package org.supersense.leetcode.problems.p34;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        return binarysearch(A, 0, A.length - 1, target);
    }
    
    private int[] binarysearch(int[] A, int begin, int end, int num){
    	int[] B = new int[2];
    	if(begin >= end){
    		if(A[begin] == num){
    			B[0] = begin;
    			B[1] = begin;
    		}else{
    			B[0] = -1;
    			B[1] = -1;
    		}
    		return B;
    	}
    	int mid = (end + begin)/2;
    	if(A[mid] == num){
    		int leftpos = leftsearch(A, begin, mid -1, num);
    		int rightpos = rightsearch(A, mid + 1, end, num);
    		if(leftpos != -1){
    			B[0] = leftpos;
    		}else{
    			B[0] = mid;
    		}
    		if(rightpos != -1){
    			B[1] = rightpos;
    		}else{
    			B[1] = mid;
    		}
    		return B;
    	}else if(A[mid] < num){
    		return binarysearch(A, mid + 1, end, num);
    	}else{
    		return binarysearch(A, begin, mid - 1, num);
    	}
    }
    
    private int leftsearch(int[] A, int begin, int end, int num){
    	{
        	if(begin >= end){
        		if(A[begin] == num){
        			return begin;
        		}else{
        			return -1;
        		}
        	}
        	int mid = (end + begin)/2;
        	if(A[mid] == num){
        		int leftpos = leftsearch(A, begin, mid - 1, num);
        		if(leftpos != -1){
        			return leftpos;
        		}else{
        			return mid;
        		}
        	}else{
        		return leftsearch(A, mid+1, end, num);
        	}
        }
    }
    
    private int rightsearch(int[] A, int begin, int end, int num){
    	{
        	if(begin >= end){
        		if(A[begin] == num){
        			return begin;
        		}else{
        			return -1;
        		}
        	}
        	int mid = (end + begin)/2;
        	if(A[mid] == num){
        		int rightpos = rightsearch(A, mid + 1, end, num);
        		if(rightpos != -1){
        			return rightpos;
        		}else{
        			return mid;
        		}
        	}else{
        		return rightsearch(A, begin, mid - 1, num);
        	}
        }
    }
}
