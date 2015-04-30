package org.supersense.leetcode.problems.p57;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.supersense.leetcode.problems.utils.Interval;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new LinkedList<Interval>();
        if(intervals.isEmpty()){
        	ret.add(newInterval);
        	return ret;
        }
        Iterator<Interval> itr = intervals.iterator();
        boolean inserted = false;
        while(itr.hasNext()){
        	Interval in = itr.next();
        	if(inserted == false){
        		if(in.end < newInterval.start){
        			ret.add(in);
        		}else if(in.start > newInterval.end){
        			ret.add(newInterval);
        			ret.add(in);
        			inserted = true;
        		}else if(in.start <= newInterval.start && in.end <= newInterval.end){
        			newInterval.start = in.start;
        		}else if(in.start >= newInterval.start && in.end >= newInterval.end){
        			newInterval.end = in.end;
        		}else if(in.start <= newInterval.start && in.end >= newInterval.end){
        			ret.add(in);
        			inserted = true;
        		}
        	}else{
        		ret.add(in);
        	}
        }
        if(!inserted){
        	ret.add(newInterval);
        }
        return ret;
    }
}
