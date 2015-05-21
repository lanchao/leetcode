package org.supersense.leetcode.problems.p211;

import java.util.HashMap;
import java.util.Map;


public class Solution {
    
	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
		
		return searchFromNode(word, root);
    }
    
    private boolean searchFromNode(String word, TrieNode root){
		Map<Character, TrieNode> map = root.children;
		if(map == null)
			return false;
		if(word == null || word.isEmpty()){
			if (map.containsKey('$')) {
				return true;
			} else {
				return false;
			}
		}
		char c = word.charAt(0);
		String sub = word.substring(1);
		if(c == '.'){
			for(char key : map.keySet()){
				TrieNode child = map.get(key);
				if(searchFromNode(sub, child)){
					return true;
				}
			}
			return false;
		}
		else{
			if(map.containsKey(c)){
				return searchFromNode(sub, map.get(c));
			}else{
				return false;
			}
		}
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
class Trie {
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

class TrieNode {
	// Initialize your data structure here.
	char value;
	Map<Character, TrieNode> children;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
}

