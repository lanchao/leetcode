package org.supersense.leetcode.problems.p207;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses < 2) {
			return true;
		}
		if (prerequisites == null || prerequisites.length == 0) {
			return true;
		}
		boolean[] visited = new boolean[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for (int[] edge : prerequisites) {
			if (graph.containsKey(edge[0])) {
				graph.get(edge[0]).add(edge[1]);
			} else {
				List<Integer> l = new LinkedList<Integer>();
				l.add(edge[1]);
				graph.put(edge[0], l);
			}
		}
		for (int i = 0; i < numCourses; i++) {
			if (dfs(graph, visited, new boolean[numCourses], i)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] stack, 
			int s) {
		if (!graph.containsKey(s)) {
			return false;
		}
		if(stack[s]){
			return true;
		}
		if (visited[s]) {
			return false;
		}
		visited[s] = true;
		stack[s] = true;
		for (Integer ss : graph.get(s)) {
			if (dfs(graph, visited, stack, ss)) {
				return true;
			}
		}
		return false;
	}
}