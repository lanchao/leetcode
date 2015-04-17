package org.supersense.leetcode.problems.p93;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> ret = new LinkedList<String>();
		dfs(ret, new Stack<String>(), s.toCharArray(), 0);
		return ret;
	}

	private void dfs(List<String> ret, Stack<String> curr, char[] cs, int idx) {

		if (curr.size() == 4 && idx >= cs.length) {
			String ss = "";
			for (String s : curr) {
				ss = ss + s + ".";
			}
			ss = ss.substring(0, ss.length() - 1);
			ret.add(ss);
			return;
		}
		if (curr.size() < 4) {
			char[] ncs = new char[3];
			if (idx < cs.length) {
				ncs[0] = cs[idx];
				String ns1 = String.valueOf(ncs[0]);
				curr.push(ns1);
				dfs(ret, curr, cs, idx + 1);
				curr.pop();
				if (ncs[0] != '0' && idx < cs.length - 1) {
					ncs[1] = cs[idx + 1];
					String ns2 = String.valueOf(ncs, 0, 2);
					curr.push(ns2);
					dfs(ret, curr, cs, idx + 2);
					curr.pop();
					if (idx < cs.length - 2) {
						ncs[2] = cs[idx + 2];
						int count = 100 * (ncs[0] - '0') + 10 * (ncs[1] - '0')
								+ ncs[2] - '0';
						if (count >= 0 && count <= 255) {
							String ns3 = String.valueOf(ncs, 0, 3);
							curr.push(ns3);
							dfs(ret, curr, cs, idx + 3);
							curr.pop();
						}
					}
				}

			}

		}

	}
}
