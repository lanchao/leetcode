package org.supersense.leetcode.problems.p149;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		}
		if (points.length < 2) {
			return points.length;
		}
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			map.put(Double.MAX_VALUE, 0);
			int dup = 1;
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				} else if (points[i].x == points[j].x
						&& points[i].y == points[j].y) {
					dup++;
				} else {
					if (points[i].x - points[j].x == 0) {
						int oldvalue = map.get(Double.MAX_VALUE);
						map.put(Double.MAX_VALUE, oldvalue + 1);
					} else {
						double slope = (double) (points[i].y - points[j].y)
								/ (double) (points[i].x - points[j].x);
						if (map.containsKey(slope)) {
							int oldvalue = map.get(slope);
							map.put(slope, oldvalue + 1);
						} else {
							map.put(slope, 1);
						}
					}
				}
			}
			for (Double s : map.keySet()) {
				if (max < map.get(s) + dup) {
					max = map.get(s) + dup;
				}
			}
		}
		return max;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
