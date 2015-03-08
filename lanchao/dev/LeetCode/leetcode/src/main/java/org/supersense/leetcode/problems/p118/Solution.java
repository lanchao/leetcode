package problems.p118;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>(numRows);

		for (int i = 0; i < numRows; i++) {
			if (i == 0) {
				List<Integer> firstRow = new ArrayList<Integer>();
				firstRow.add(new Integer(1));
				ret.add(firstRow);
			} else {
				List<Integer> lastrow = ret.get(i - 1);
				List<Integer> thisrow = new ArrayList<Integer>();
				for (int j = 0; j <= i; j++) {
					int fi = j - 1;
					int si = j;
					int f, s;
					if (fi < 0) {
						f = 0;
					} else {
						f = lastrow.get(fi);
					}
					if (si > lastrow.size() - 1) {
						s = 0;
					} else {
						s = lastrow.get(si);
					}
					thisrow.add(new Integer(f + s));
				}
				ret.add(thisrow);
			}
		}
		return ret;
	}
}
