package org.supersense.leetcode.problems.p53;

public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int currmax = A[0];
        for(int i = 1; i < A.length; i++){
            currmax += A[i];
            if(currmax < A[i]){
                currmax = A[i];
            }
            if(max < currmax){
                max = currmax;
            }
        }
        return max;
    }
}
