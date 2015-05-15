package org.supersense.leetcode.problems.p210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) {
			return new int[0];
		}
		ArrayList<Integer> ret = new ArrayList<Integer>();
		boolean[] visited = new boolean[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		if (prerequisites != null && prerequisites.length != 0) {
			for (int[] edge : prerequisites) {
				if (graph.containsKey(edge[0])) {
					graph.get(edge[0]).add(edge[1]);
				} else {
					List<Integer> l = new LinkedList<Integer>();
					l.add(edge[1]);
					graph.put(edge[0], l);
				}
			}
		}
		for (int i = 0; i < numCourses; i++) {
			if (dfs(graph, visited, new boolean[numCourses], i, ret)) {
				return new int[0];
			}
		}
		return buildIntArray(ret);
	}

	private int[] buildIntArray(List<Integer> integers) {
		int[] ints = new int[integers.size()];
		int i = 0;
		for (Integer n : integers) {
			ints[i++] = n;
		}
		return ints;
	}

	private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited,
			boolean[] stack, int s, List<Integer> ret) {
		if (stack[s]) {
			return true;
		}
		
		if (visited[s]) {
			return false;
		}
		if (!graph.containsKey(s)) {
			ret.add(s);
			visited[s] = true;
			return false;
		}
		visited[s] = true;
		stack[s] = true;
		for (Integer ss : graph.get(s)) {
			if (dfs(graph, visited, stack, ss, ret)) {
				return true;
			}
		}
		ret.add(s);
		return false;
	}
}
