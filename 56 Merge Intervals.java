/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        if(intervals == null || intervals.size() == 0) {
            return intervals;
        }
        
        int size = intervals.size();
        List<Interval> result = new ArrayList<Interval>(size);
        
        PriorityQueue<Interval> q = new PriorityQueue<Interval>(size, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        for(Interval i:intervals) {
            q.offer(i);
        }
        
        Interval prev = q.poll();
        while(q.isEmpty() == false) { 
            Interval current = q.poll();
            if(prev.end >= current.start) {
                if(current.end > prev.end) {
                    prev.end = current.end;
                }
            } else {
                result.add(prev);
                prev = current;
            }
        }
        result.add(prev);
        return result;
    }
}
