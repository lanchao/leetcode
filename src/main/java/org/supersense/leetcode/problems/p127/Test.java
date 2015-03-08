package org.supersense.leetcode.problems.p127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] ss = {"hot","dot","dog","lot","log"};
		Set<String> sss = new HashSet<String>();
		sss.addAll(Arrays.asList(ss));
		System.out.println(s.ladderLength("hit", "cog", sss));
	}

}
