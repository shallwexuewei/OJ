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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null)   return 0;
        
        int len = intervals.length;
        if(len < 1)             return 0;
        if(len == 1)            return 1;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
           @Override
           public int compare(Interval a, Interval b) {
               return a.start - b.start;
           }
        });
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.add(intervals[0].end);
        for(int i = 1; i < len; i++) {
            if(intervals[i].start < q.peek()){
                q.add(intervals[i].end);
            } else {
                q.poll();
                q.add(intervals[i].end);
            }
        }
        return q.size();
    }
}
