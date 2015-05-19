package org.supersense.leetcode.problems.p126;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
	private int shortest = Integer.MAX_VALUE;

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> ret = new LinkedList<List<String>>();
		List<List<String>> path = new ArrayList<List<String>>();
		List<String> ll = new LinkedList<String>();
		// dict.add(end);
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		buildgraph(map, dict, start, end);
		// dfsOnMap(map, start, end, dict, ret, ll, 0);
		bfs(map, start, end, dict, path);
		dfsPath(map, start, end, path, ret, ll, 0);
		return ret;
	}

	private void bfs(Map<String, Set<String>> map, String start, String end,
			Set<String> dict, List<List<String>> path) {
		Set<String> temp = new HashSet<String>();
		temp.addAll(dict);
		temp.remove(start);
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		queue.add(null);
		path.add(new LinkedList<String>());
		while (!queue.isEmpty() && queue.peek() != null) {
			String s = queue.poll();
			if (s.equals(end)) {
				return;
			}
			Set<String> nss = map.get(s);
			for (String ns : nss) {
				if (temp.contains(ns)) {
					path.get(path.size() - 1).add(ns);
					queue.add(ns);
					temp.remove(ns);
				}
			}
			if (queue.peek() == null) {
				queue.poll();
				queue.add(null);
				path.add(new LinkedList<String>());
			}
		}
	}

	private void dfsPath(Map<String, Set<String>> map, String start,
			String end, List<List<String>> path, List<List<String>> ret,
			List<String> pl, int depth) {
		List<String> curr = new LinkedList<String>();
		curr.addAll(pl);
		if (start.equals(end)) {
			curr.add(start);
			ret.add(curr);
			return;
		}
		if (depth >= path.size()) {
			return;
		}
		curr.add(start);
		List<String> ls = path.get(depth);
		Set<String> nset = map.get(start);
		for (String s : ls) {
			if (nset.contains(s)) {
				dfsPath(map, s, end, path, ret, curr, depth + 1);
			}
		}
	}

	private void dfsOnMap(Map<String, List<String>> map, String start,
			String end, Set<String> dict, List<List<String>> ret,
			List<String> pl, int depth) {
		List<String> curr = new LinkedList<String>();

		if (depth > shortest) {
			return;
		}
		if (dict.isEmpty()) {
			return;
		}
		curr.addAll(pl);
		curr.add(start);
		if (start.equals(end)) {
			if (depth <= shortest) {
				shortest = depth;
				ret.add(curr);
				return;
			}
			return;
		}
		List<String> candlist = map.get(start);
		for (String rep : candlist) {
			if (dict.contains(rep)) {
				dict.remove(rep);
				dfsOnMap(map, rep, end, dict, ret, curr, depth + 1);
				dict.add(rep);
			}
		}
	}

	private void dfs(String start, String end, Set<String> dict,
			List<List<String>> ret, List<String> pl, int depth) {
		List<String> curr = new LinkedList<String>();

		if (depth > shortest) {
			return;
		}
		if (dict.isEmpty()) {
			return;
		}
		curr.addAll(pl);
		curr.add(start);
		if (start.equals(end)) {
			if (depth <= shortest) {
				shortest = depth;
				ret.add(curr);
				return;
			}
			return;
		}

		char[] cc = start.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			char t = cc[i];
			for (cc[i] = 'a'; cc[i] <= 'z'; cc[i]++) {
				String rep = String.valueOf(cc);
				if (dict.contains(rep)) {
					dict.remove(rep);
					dfs(rep, end, dict, ret, curr, depth + 1);
					dict.add(rep);
				}
			}
			cc[i] = t;
		}
	}

	private boolean editDistanceOne(String s1, String s2) {
		int count = 0;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		for (int i = 0; i < s1.length(); i++) {
			if (c1[i] != c2[i]) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}
		if (count == 1) {
			return true;
		}
		return false;
	}

	private void buildgraph(Map<String, Set<String>> map, Set<String> dict,
			String start, String end) {
		Set<String> sl = new HashSet<String>();
		Set<String> temp = new HashSet<String>();
		temp.addAll(dict);
		temp.add(end);
		/*for (String s : temp) {
			if (editDistanceOne(start, s)) {
				sl.add(s);
			}
		}*/
		sl.addAll(neighbors(start, temp));
		map.put(start, sl);

		for (String s : dict) {
			temp.remove(s);
			Set<String> ll = new HashSet<String>();
			/*for (String t : temp) {
				if (editDistanceOne(s, t)) {
					ll.add(t);
				}
			}*/
			ll.addAll(neighbors(s, temp));
			temp.add(s);
			map.put(s, ll);
		}
	}
	
	private List<String> neighbors(String s, Set<String> dict){
        List<String> list = new ArrayList<String>();
        char[] chars = s.toCharArray();
        for(int j = 0;j < s.length();j++){
            char original = chars[j];
            for(char c = 'a';c <= 'z';c++){
                chars[j] = c;
                String t = new String(chars);
                if(dict.contains(t)) list.add(t);
            }
            chars[j] = original;
        }
        return list;
    }
}
