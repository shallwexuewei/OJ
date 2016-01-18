public class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi) {
            if(nums[lo] < nums[hi]) {
                return nums[lo];
            }
            
            int mid = lo + (hi - lo)/2;
            
            if(nums[lo] <= nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}

/*
test case:
1
*/
