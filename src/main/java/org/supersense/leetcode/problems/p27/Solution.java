package org.supersense.leetcode.problems.p27;

public class Solution {
    public int removeElement(int[] A, int elem) {
        int length = A.length;
        int i = 0;
        while(i < length){
        	if(A[i] == elem){
        		int j = length - 1;
        		while(j > i && A[j] == elem){
        			j--;
        		}
        		A[i] = A[j];
        		length = j;
        	}
    		i++;
        }
        return length;
    }
}
