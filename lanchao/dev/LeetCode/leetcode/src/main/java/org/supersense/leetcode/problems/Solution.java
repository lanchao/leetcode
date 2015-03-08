package org.supersense.leetcode.problems;

public class Solution {

	public boolean isPalindrome(int x) {
		if(x < 0){
			return false;
		}
        int left = (int) Math.pow(10, Math.floor(Math.log10(x)));
        int right = 1;
        while(left > right){
        	if((x/left - x/right)%10 != 0){
        		return false;
        	}
        	left /= 10;
        	right *= 10;
        }
        return true;
    }
}
