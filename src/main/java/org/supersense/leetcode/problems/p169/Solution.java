package org.supersense.leetcode.problems.p169;

public class Solution {

    public int majorityElement(int[] num) {
        int count = 1;
        int vote = num[0];
        for(int i = 1; i < num.length; i++){
        	if(vote != num[i]){
        		count--;
        		if(count < 0){
        			vote = num[i];
        			count = 1;
        		}
        	}else{
        		count++;
        	}
        }
        return vote;
    }
}
