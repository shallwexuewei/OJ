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
        
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
           @Override
           public int compare(Interval a, Interval b) {
               return a.start - b.start;
           }
        });
        
        // use an array storing the end time of each meeting rooms
        ArrayList<Integer> ends = new ArrayList<Integer>();
        for(Interval i:intervals) {
            if(ends.isEmpty()){
                ends.add(i.end);
            }
            else {
                int minJ = -1;
                int minDiff = Integer.MAX_VALUE;
                for(int j = 0; j < ends.size(); j++) {
                    if(ends.get(j) <= i.start) {
                        int diff = i.start - ends.get(j);
                        if(diff < minDiff) {
                            diff = minDiff;
                            minJ = j;
                        } 
                    }
                }
                if(minJ == -1) { 
                    ends.add(i.end);
                } else {
                    ends.set(minJ, i.end);
                }
            } 
        }
        return ends.size();
    }
}

/*
Wrong Answer More Details 

Input:
[[13,15],[1,13]]
Output:
2
Expected:
1

Wrong Answer More Details 

Input:
[[1293,2986],[848,3846],[4284,5907],[4466,4781],[518,2918],[300,5870]]
Output:
5
Expected:
4
*/
