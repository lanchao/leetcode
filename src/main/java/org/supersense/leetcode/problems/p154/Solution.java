package org.supersense.leetcode.problems.p154;

public class Solution {
    public int findMin(int[] num) {
    	int start = 0, end = num.length -1, mid;
        while(start < end){
        	mid = (start + end)/2;
        	if(num[mid] < num[end]){
        		end = mid;
        	}else if(num[mid] > num[end]){
        		start = mid + 1;
        	}else{
        		if(num[mid] != num[start]){
        			end = mid;
        		}else{
        			start++;
        			end--;
        		}
        	}
        }
        return num[end];
    }
}
