package org.supersense.leetcode.problems.p146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
	private Map<Integer, Value> map;
	//private LinkedList<Integer> list;
	private PriorityQueue<Value> queue;
	private int capacity;
	private long timestamp = 0;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, Value>(capacity);
		//list = new LinkedList<Integer>();
		queue = new PriorityQueue<Value>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		timestamp++;
		if (map.containsKey(key)) {
			Value v = map.get(key);
			queue.remove(v);
			v.timestamp = timestamp++;
			queue.add(v);
			//list.addFirst(key);
			return v.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		Value nv = new Value(key, value, timestamp++);
		if(map.containsKey(key)){
			queue.remove(map.get(key));
		}
		if (queue.size() == capacity) {
			int oldkey = queue.poll().key;
			//list.addFirst(key);
			map.remove(oldkey);
			map.put(key, nv);
			queue.add(nv);
		} else {
			map.put(key, nv);
			queue.add(nv);
			//list.addFirst(key);
		}
	}
	
	private class Value implements Comparable<Value>{
		int key;
		int value;
		long timestamp;
		Value(int key, int value, long timestamp){
			this.key = key;
			this.value = value;
			this.timestamp = timestamp;
		}
		@Override
		public int compareTo(Value o) {
			// TODO Auto-generated method stub
			return Long.compare(timestamp, o.timestamp);
		}
	}
}
