public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while(lo <= hi) {
            mid = lo + (hi - lo)/2;
            if(nums[mid] > target) {
                hi = mid - 1;
            } else if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                break;
            }
        }
        if(lo > hi) {
            return lo;
        } else {
            return mid;
        }
    }
}
