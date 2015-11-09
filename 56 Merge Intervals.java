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
        // if(intervals == null)
        int len = intervals.size();
        List<Interval> result = new LinkedList<Interval>();
        if(len == 0) {
            return result;
        }
        
        Comparator<Interval> comparator = new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        };
        
        Collections.sort(intervals, comparator);
        
        int i = 1;
        Interval current = new Interval(intervals.get(0).start, intervals.get(0).end);
        while(i < len) {
            Interval next = intervals.get(i);
            if(current.end >= next.start){
                if( current.end < next.end) {
                    current.end = next.end;
                }
            } else {
                result.add(current);
                current = new Interval(next.start, next.end);
            }
            i++;
        }
        result.add(current);
        
        return result;
    }
}
