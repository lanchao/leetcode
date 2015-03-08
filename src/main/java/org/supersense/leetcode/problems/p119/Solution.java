package org.supersense.leetcode.problems.p119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> oldrow = null;
    	List<Integer> current = new ArrayList<Integer>();

		for (int i = 0; i <= rowIndex; i++) {
			if (i == 0) {
				current.add(new Integer(1));
			} else {
				oldrow = current;
				current = new ArrayList<Integer>();
				for (int j = 0; j <= i; j++) {
					int fi = j - 1;
					int si = j;
					int f, s;
					if (fi < 0) {
						f = 0;
					} else {
						f = oldrow.get(fi);
					}
					if (si > oldrow.size() - 1) {
						s = 0;
					} else {
						s = oldrow.get(si);
					}
					current.add(new Integer(f + s));
				}
			}
		}
		return current;
    }
}
