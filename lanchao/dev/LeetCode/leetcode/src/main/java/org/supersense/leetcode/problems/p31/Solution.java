package org.supersense.leetcode.problems.p31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] num) {
        for(int i = num.length - 2; i >= 0; i--){
        	if(num[i] < num[i+1]){
        		int pos = i;
        		int diff = Integer.MAX_VALUE;
        		for(int j = i + 1; j < num.length; j++){
        			if(num[i] < num[j] && diff > Math.abs(num[i] - num[j])){
        				pos = j;
        				diff = Math.abs(num[i] - num[j]);
        			}
        		}
        		int tmp = num[i];
        		num[i] = num[pos];
        		num[pos] = tmp;
        		Arrays.sort(num, i + 1, num.length);
        		return;
        	}
        }
        Arrays.sort(num, 0, num.length);
    }   
}