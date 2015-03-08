package problems.p136;

public class Solution {
    public int singleNumber(int[] A) {
    	int count = 0;
        for(int i = 0; i < A.length ;i++){
        	count ^= A[i];
        }
        return count;
    }
}
