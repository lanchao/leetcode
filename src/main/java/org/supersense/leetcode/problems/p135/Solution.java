package org.supersense.leetcode.problems.p135;

import java.util.Arrays;


public class Solution {
    public int candy(int[] ratings) {
        int count = 0;
        int[] cand = new int[ratings.length];
        Arrays.fill(cand, 1);
        for(int i = 1; i < ratings.length; i++){
        	if(ratings[i] > ratings[i - 1]){
        		cand[i] = cand[i - 1] + 1;
        	}
        }
        count += cand[ratings.length - 1];
        for(int i = ratings.length - 2; i >=0 ; i--){
        	if(ratings[i] > ratings[i + 1]){
        		if(i > 0 && ratings[i] > ratings[i - 1]){
        			cand[i] = Math.max(cand[i], cand[i + 1] + 1);
        		}else{
        			cand[i] = cand[i + 1] + 1;
        		}
        	}
        	count += cand[i];
        }
        return count;
    }
}
