package org.supersense.leetcode.problems.p6;

///nRows:2
///1,   3,  5   step: 2
///2,   4,  6   step: 2
///
///nRows:3
///1,       5,      9   step:   4
///2,   4,  6,  8,  10  step:2      2
///3,       7,      11  step:   4
///
///nRows:4
///1,           7,          13  step:   6
///2,       6,  8,      12, 14  step:4      2
///3,   5       9,  11,     15  step:2      4
///4,           10,         16  step:   6
///
///nRows:5
///1,               9,              17  step:   8
///2,           8,  10,         16, 18  step:6      2
///3,       7,      11,     15,     19  step:4      4
///4,   6,          12, 14,         20  step:2      6
///5,               13,             21  step:    8
///

public class Solution {
	public String convert(String s, int nRows) {
		if(s.length() <= nRows || nRows <= 1){
			return s;
		}
		StringBuilder sb = new StringBuilder();
		char[] cc = s.toCharArray();
		int max_step = (nRows - 1) * 2;
		for(int i = 0; i < nRows; i++){
			int pos = i;
			if(i == 0 || i == nRows - 1){
				while(pos < cc.length){
					sb.append(cc[pos]);
					pos += max_step;
				}
			}else{
				int step = 2 * i;
				while(pos < cc.length){
					sb.append(cc[pos]);
					step = max_step - step;
					pos += step;
				}
			}
		}
		return sb.toString();
	}
}
