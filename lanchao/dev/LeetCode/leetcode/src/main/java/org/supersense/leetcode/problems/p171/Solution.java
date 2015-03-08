package problems.p171;

public class Solution {
	public int titleToNumber(String s) {
		int num = 0;
		for(int i = 0; i < s.length(); i++){
			int dig = s.charAt(i) - 'A' + 1;
			num = num * 26 + dig; 
		}
		return num;
    }
}
