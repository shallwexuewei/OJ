public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length; 
        int low = 0;
        int high = len - 1;
        int last = len - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] <= nums[last]) {
                if(mid == 0 || nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

/*
test case:
1
*/
