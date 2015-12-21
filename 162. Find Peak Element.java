public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int i = 1;
        int len = nums.length;
        while (i < nums.length - 1) {
            if(nums[i] > nums[i-1]) {
                if(nums[i] > nums[i+1]) {
                    return i;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        
        if(len == 1) {
            return 0;
        } else {
            if(nums[0] > nums[1]) {
                return 0;
            } 
            if(nums[len-1] > nums[len-2]) {
                return len-1;
            }
        }
        return -1;
    }
}
