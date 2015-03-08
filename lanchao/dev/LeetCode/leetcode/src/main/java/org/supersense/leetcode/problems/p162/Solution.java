package org.supersense.leetcode.problems.p162;

public class Solution {
    public int findPeakElement(int[] num) {
        return findPeak(num, 0, num.length-1);
    }
    
    public int findPeak(int[] num, int start, int end){
    	if(start == end){
    		return start;
    	}else{
    		int mid = (start + end)/2;
    		int left = findPeak(num, start, mid);
    		int right = findPeak(num, mid+1, end);
    		return (num[left]>num[right])?left:right;
    	}
    }
}
