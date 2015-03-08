package org.supersense.leetcode.problems.p153;

public class Solution {
	public int findMin(int[] num) {
        int start = 0, end = num.length -1, mid;
        while(start < end){
        	mid = (start + end)/2;
        	if(num[mid] < num[end]){
        		end = mid;
        	}else if(num[mid] > num[end]){
        		start = mid + 1;
        	}
        }
        return num[end];
    }
}
