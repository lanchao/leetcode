package org.supersense.leetcode.problems.p133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	private Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	private Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	map.clear();
    	queue.clear();
    	return dfs(node);
    	//return bfs(node);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
    	if(node == null){
    		return null;
    	}
    	if(map.containsKey(node.label)){
    		return map.get(node.label);
    	}
    	UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    	map.put(newNode.label, newNode);
    	for(UndirectedGraphNode n : node.neighbors){
    		newNode.neighbors.add(dfs(n));
    	} 	
    	return newNode;
    }
    
    private UndirectedGraphNode bfs(UndirectedGraphNode node) {
    	if(node == null){
    		return null;
    	}
    	UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
    	queue.add(node);
    	map.put(ret.label, ret);
    	while(!queue.isEmpty()){ 		
    		UndirectedGraphNode cnode = queue.poll();
    		UndirectedGraphNode newNode = map.get(cnode.label);
    		for(UndirectedGraphNode neighbor: cnode.neighbors){
    			if(map.containsKey(neighbor.label)){
    				newNode.neighbors.add(map.get(neighbor.label));
    			}else{
    				UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
    				newNode.neighbors.add(newNeighbor);
    				map.put(newNeighbor.label, newNeighbor);
    				queue.add(neighbor);
    			}
    		}
    	}
    	return ret;
    }
}

class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}