package org.supersense.leetcode.problems.p198;

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int rob = 0, notrob = 0, prerob, prenotrob;
        for(int n : nums){
        	prerob = rob;
        	prenotrob = notrob;
        	rob = prenotrob + n;
        	notrob = Math.max(prerob, prenotrob);
        }
        return Math.max(rob, notrob);
    }
}
