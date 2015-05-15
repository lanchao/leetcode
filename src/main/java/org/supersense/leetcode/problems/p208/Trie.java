package org.supersense.leetcode.problems.p208;

import java.util.HashMap;
import java.util.Map;

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
        for(char c : cw){
        	if(map.containsKey(c)){
        		TrieNode child = map.get(c);
        		map = child.children;
        	}else{
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
        for(char c : cw){
        	if(map.containsKey(c)){
        		TrieNode child = map.get(c);
        		map = child.children;
        	}else{
        		return false;
        	}
        }
        if(map.containsKey('$')){
        	return true;
        }else{
        	return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	char[] cw = prefix.toCharArray();
        Map<Character, TrieNode> map = root.children;
        for(char c : cw){
        	if(map.containsKey(c)){
        		TrieNode child = map.get(c);
        		map = child.children;
        	}else{
        		return false;
        	}
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");