package org.supersense.leetcode.problems.p56;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.supersense.leetcode.problems.utils.Interval;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals.size() <= 1)
    		return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start)
					return -1;
				else if(o1.start == o2.start)
					return 0;
				else
					return 1;
			}
        });
        List<Interval> ret = new LinkedList<Interval>();
        Iterator<Interval> itr = intervals.iterator();
        Interval in = itr.next();
        while(itr.hasNext()){
        	Interval next = itr.next();
        	if(in.end < next.start){
        		ret.add(in);
        		in = next;
        	}else if(in.end < next.end){
        		in.end = next.end;
        	}
        }
        ret.add(in);
        return ret;
    }
}
