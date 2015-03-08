package org.supersense.leetcode.problems.p137;

public class Solution {
    public int singleNumber(int[] A) {
        int bit0 = 0;
        int bit1 = 0;
        int bit2 = 0;
        for(int i = 0; i< A.length ;i++){
            bit2 = bit1 & A[i];
            bit1 = bit0 & A[i] | bit1;
            bit0 = bit0 | A[i];
            bit0 = bit0 &(~bit2);
            bit1 = bit1 & (~bit2);
            bit2 = 0;
        }
        return bit0;
    }
}
