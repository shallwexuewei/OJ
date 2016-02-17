public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        
        int lo = 0;
        int hi = len - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int num = len - mid;
            if(citations[mid] > num) {
                hi = mid - 1;
            } else if(citations[mid] < num) {
                lo = mid + 1;
            } else {
                return num;
            }
        }
        return (len - lo);
    }
}
