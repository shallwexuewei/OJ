public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null)    return 0;
        
        int size = nums.length;
        if(size < 2)        return size;
        
        int[] sub = new int[size];
        int last = 0;
        sub[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > sub[last]) {
                sub[++last] = nums[i];
            } else {
                int ceilIndex = getCeilIndex(sub, 0, last, nums[i]);
                sub[ceilIndex] = nums[i];
            }
        }
        return last + 1;
    }
    
    private int getCeilIndex(int[] sub, int lo, int hi, int target) {
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            if(sub[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
