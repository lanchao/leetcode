package org.supersense.leetcode.problems.p16;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
    	if(num == null || num.length < 3){
    		return 0;
    	}
    	Arrays.sort(num);
    	int min = num[0]+num[1]+num[2];
    	for(int i = 0; i < num.length -2;i++){
    		int a = num[i];
    		int start = i+ 1;
    		int end = num.length -1;
    		int b = 0, c = 0;
    		while(start < end){
    			b = num[start];
    			c = num[end];
    			if(a + b + c < target){
    				while(start<end && num[start] == b){
    					start++;
    				}
    			}else if(a + b + c > target){
    				while(start<end && num[end] == c){
    					end--;
    				}
    			}else{
    				return target;
    			}
    			if(Math.abs((min - target)) > Math.abs((a + b + c - target))){
        			min = a + b + c;
        		}
    		}   		
    		while(i+1<num.length && num[i+1] == num[i]){
    			i++;
    		}
    	}
    	return min;
    }
}
