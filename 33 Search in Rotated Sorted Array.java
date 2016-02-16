public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] < nums[hi]) {
                if(nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else if(nums[mid] == target) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                if(nums[lo] <= target && nums[mid] > target) {
                    hi = mid - 1;
                } else if(nums[mid] == target) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
        
    }
}
