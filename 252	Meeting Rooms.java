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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null) {
            return false;
        }
        
        int len = intervals.length;
        if(len < 1) {
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }); 
        
        int prev = intervals[0].end;
        for(int i = 1; i < len; i++) {
            if(intervals[i].start < prev) return false;
            prev = intervals[i].end;
        }
        return true;
        
    }
}

/*
 Wrong Answer More Details 

Input:
[[7,10],[2,4]]
Output:
false
Expected:
true
*/
