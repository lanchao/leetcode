package org.supersense.leetcode.problems.p212;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public List<String> findWords(char[][] board, String[] words) {
		List<String> ret = new LinkedList<String>();
		Trie trie = new Trie();
		Set<String> wordset = new HashSet<String>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (String s : words) {
			trie.insert(s);
			wordset.add(s);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!wordset.isEmpty()) {
					dfs(ret, board, visited, i, j, "", trie, wordset);
				}
			}
		}
		return ret;
	}

	private void dfs(List<String> ret, char[][] board, boolean visited[][],
			int i, int j, String s, Trie trie, Set<String> set) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
			return;
		}
		if(visited[i][j]){
			return;
		}
		if(set.isEmpty()){
			return;
		}
		String ns = s + board[i][j];
		if (trie.startsWith(ns)) {
			visited[i][j] = true;
			if (set.contains(ns)) {
				ret.add(ns);
				set.remove(ns);
			}
			dfs(ret, board, visited, i + 1, j, ns, trie, set);
			dfs(ret, board, visited, i, j + 1, ns, trie, set);
			dfs(ret, board, visited, i - 1, j, ns, trie, set);
			dfs(ret, board, visited, i, j - 1, ns, trie, set);
			visited[i][j] = false;
		}

	}

	class TrieNode {
		// Initialize your data structure here.
		char value;
		Map<Character, TrieNode> children;

		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			char[] cw = word.toCharArray();
			Map<Character, TrieNode> map = root.children;
			for (char c : cw) {
				if (map.containsKey(c)) {
					TrieNode child = map.get(c);
					map = child.children;
				} else {
					TrieNode child = new TrieNode();
					child.value = c;
					map.put(c, child);
					map = child.children;
				}
			}
			map.put('$', new TrieNode());
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			char[] cw = word.toCharArray();
			Map<Character, TrieNode> map = root.children;
			for (char c : cw) {
				if (map.containsKey(c)) {
					TrieNode child = map.get(c);
					map = child.children;
				} else {
					return false;
				}
			}
			if (map.containsKey('$')) {
				return true;
			} else {
				return false;
			}
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			char[] cw = prefix.toCharArray();
			Map<Character, TrieNode> map = root.children;
			for (char c : cw) {
				if (map.containsKey(c)) {
					TrieNode child = map.get(c);
					map = child.children;
				} else {
					return false;
				}
			}
			return true;
		}
		
		public boolean remove(String word){
			return removeFromNode(word, root, 0);
		}
		
		private boolean removeFromNode(String word, TrieNode root, int idx){
			if(root.children == null){
				return false;
			}
			if(idx == word.length()){
				Map<Character, TrieNode> map = root.children;
				return (map.remove("$").equals("$"));
			}
			char c = word.charAt(idx);
			Map<Character, TrieNode> map = root.children;
			if(map.containsKey(c)){
				TrieNode child = map.get(c);
				if(removeFromNode(word, child, idx + 1)){
					if(child.children.isEmpty()){
						map.remove(c);
					}
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	}
}
