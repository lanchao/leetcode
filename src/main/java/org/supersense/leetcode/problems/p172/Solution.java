package problems.p172;

public class Solution {
	public int trailingZeroes(int n) {
		int ret = 0;
		int five = n;
		while((five /= 5) != 0){
			ret += five;
		}	
		return ret;
	}
}
